package com.example.demo.controller.yxtapp;

import com.example.demo.pojo.yxtapp.GytDoctorLogin;
import com.example.demo.service.yxtapp.TestService;
import com.example.demo.util.yxtUtils.SmsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/Login")
@Controller
public class LoginController {



    @Autowired
    TestService testService;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;
    /*
    * 登录
    * 功能：如果注册过直接登录
    * 如果未注册则直接注册到数据库
    * */
    @RequestMapping("/LoginF")
    @ResponseBody
    public Map<String, String> LoginF(@RequestBody Map<String,String> map,HttpSession session){

        Map<String, String> returnMap = new HashMap<>();
        String phone = map.get("phone");
        String password = map.get("password");

        //存String
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //设置序列化Value的实例化对象
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());

        //Object verifyCode = session.getAttribute("verifyCode");
        //尚未获验证码
        /*
        * 这里缺块代码，去聊天记录中复制过来
        * */


        //String vCode = verifyCode.toString();

        //判断验证码是否正确,暂时先用"1111"
        if(!"1111".equals(password)){
            returnMap.put("message","验证码错误");
            return returnMap;
        }

        //判断该手机号是否已经注册
        GytDoctorLogin doctorLogin = testService.getDoctorLogin(phone);
        //已经注册，存入redis ，并返回登录成功
        if(doctorLogin!=null){
            //key最好在加一串字符串
            //存入redis
            redisTemplate.opsForValue().set(doctorLogin.getDocLoginId()+"",doctorLogin,java.time.Duration.ofMinutes(20));
            returnMap.put("message","登录成功");
            returnMap.put("tokenUID",doctorLogin.getDocLoginId().toString());
            return returnMap;
        }

        //未注册，则添加数据库信息
        Integer integer = testService.addDoctorLoginReg(phone);
        //在把添加的数据的这条数据的id查出来，但如果用手机号加编码就不用再查
        GytDoctorLogin doctorLogin2 = testService.getDoctorLogin(phone);

        if(integer==0){
            //添加失败
            returnMap.put("message","登录失败");
            return returnMap;
        }

        //存入redis
        redisTemplate.opsForValue().set(doctorLogin2.getDocLoginId()+"",doctorLogin2,java.time.Duration.ofMinutes(20));
        returnMap.put("message","登录成功");
        returnMap.put("tokenUID",doctorLogin2.getDocLoginId().toString());


        return returnMap;
    }

    /*
    * 获取验证码
    * */
    @RequestMapping("/getVerify")
    @ResponseBody
    public Boolean getVerify(@RequestBody Map<String,String> map, HttpSession session){


        String code = SmsUtil.SendSMS(map.get("phone"));
        session.setAttribute(code,code);
        System.out.println(map.get("phone"));

        return true;
    }


    /*
    * 退出登录
    * */
    @RequestMapping("/loginOut")
    @ResponseBody
    public Boolean loginOut(HttpServletRequest request){
        String token = request.getHeader("token");
        redisTemplate.delete(token);


        return true;
    }


    @RequestMapping("/getDoctorInfo")
    @ResponseBody
    public Boolean getDoctorInfo(HttpServletRequest request){
        System.out.println("getDoctorInfo____________");
        /*String token = request.getHeader("token");
        GytDoctorLogin gytDoctorLogin = (GytDoctorLogin)redisTemplate.opsForValue().get(token);
        GytDoctorInfo doctorInformation = infoService.getDoctorInformation(gytDoctorLogin.getDocLoginId());*/

        return true;
    }




}
