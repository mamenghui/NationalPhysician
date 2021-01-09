package com.example.demo.controller.yxtapp;


import com.example.demo.pojo.yxtapp.GytDoctorInfo;
import com.example.demo.pojo.yxtapp.GytDoctorLogin;
import com.example.demo.service.yxtapp.InfoService;
import com.example.demo.util.yxtUtils.Aliyununtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RequestMapping("/InfoController")
@Controller
public class InfoController {

    @Autowired
    private InfoService infoService;
    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @RequestMapping("/getDoctorInfo")
    @ResponseBody
    public GytDoctorInfo getDoctorInfo(HttpServletRequest request){
        System.out.println("getDoctorInfo____________");
        String token = request.getHeader("token");
        GytDoctorLogin gytDoctorLogin = (GytDoctorLogin)redisTemplate.opsForValue().get(token);
        GytDoctorInfo doctorInformation = infoService.getDoctorInformation(gytDoctorLogin.getDocLoginId());
        System.out.println(doctorInformation);
        return doctorInformation;
    }


    /**
     * 选择上传文件（待定上传)
     */
    //@RequestMapping(value = "/upFile",method = RequestMethod.POST)
    //@PostMapping(value = "/upFile")
    //@PostMapping(value = "/upFile", headers = "content-type=multipart/form-data")
    //@RequestMapping("/upFile")
    //@PostMapping(value = "/upFile")

    @RequestMapping(value = "upFile")
    @ResponseBody
    public Boolean upFile(MultipartFile file,HttpServletRequest request) {
        System.out.println(file.isEmpty());

        if (file.isEmpty()) {
            System.out.println("空");
            return false;
        }
        //文件名
        String filename = file.getOriginalFilename();
        //返回一个文件路径
        //AliOSSUtil.uploadFileInputSteam(filename,file);
        String s = Aliyununtils.uploadFileInputSteam(filename, file);
        //获取sessionId
        String token = request.getHeader("token");
        GytDoctorLogin gytDoctorLogin = (GytDoctorLogin)redisTemplate.opsForValue().get(token);
        Integer docLoginId = gytDoctorLogin.getDocLoginId();
        //存redis的key-
        //String key = "ClarificaitionBookUrl" + docLoginId;


        Integer integer = infoService.updTouXiang(s, docLoginId);


        //System.out.println("上传路径："+s);
        return true;
    }

    /*
    * 获取头像信息
    * */
    @RequestMapping("/getTouXiang")
    @ResponseBody
    public String getTouXiang(HttpServletRequest request){

        String token = request.getHeader("token");
        GytDoctorLogin gytDoctorLogin = (GytDoctorLogin)redisTemplate.opsForValue().get(token);

        String touXiang = infoService.getTouXiang(gytDoctorLogin.getDocLoginId());


        return touXiang;
    }

    /*
     * 修改个人信息
     * */
    @RequestMapping("/updateDoctorInfo")
    @ResponseBody
    public boolean updateDoctorInfo(@RequestBody GytDoctorInfo gytDoctorInfo, HttpServletRequest request){
        String token = request.getHeader("token");
        GytDoctorLogin gytDoctorLogin = (GytDoctorLogin)redisTemplate.opsForValue().get(token);
        System.out.println(gytDoctorInfo);
        //多线程修改数据库为保证 缓存数据库一致的情况下，一般要加锁，但那个是高并发情况下，多角色高并发对数据库中的数据修改，
        //这。。。还不会mq，先删redis中的emmm (⇀‸↼‶) 覆盖key吧
        Integer integer = infoService.updDoctorInfo(gytDoctorInfo);
        Integer integer1 = infoService.updDoctorLogin(gytDoctorInfo);

        return true;
    }

    //测试方法
    @RequestMapping("/updateDoctorInfoTest")
    @ResponseBody
    public boolean updateDoctorInfoTest(@RequestBody GytDoctorInfo gytDoctorInfo, HttpServletRequest request){
        System.out.println("有："+gytDoctorInfo);
        return true;
    }



}
