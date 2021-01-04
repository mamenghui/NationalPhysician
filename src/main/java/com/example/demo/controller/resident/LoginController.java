package com.example.demo.controller.resident;

import com.example.demo.pojo.resident.ExUser;
import com.example.demo.service.resident.LoginService;
import com.example.demo.util.SmsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("/resiDentLog")
public class LoginController {
    @Autowired
    private LoginService loginService;

    //登录
    @RequestMapping("/logins")
    public ExUser logins(@RequestBody Map<String,String> map, HttpSession session){
        String userCode = map.get("Code");
        String userPassWord = map.get("PassWord");
        String allName = map.get("allName");
        ExUser user=loginService.login(userCode,allName);
        System.out.println(user);
        String code =(String) session.getAttribute("code");
        //code="1111";
        if(user.getUserName() != "" && userPassWord.equals(code)){
            session.setAttribute("phon",userCode);
            return user;
        }else {
            return user;
        }
    }
    //短信验证
    @RequestMapping("/authCode")
    public void authCode(@RequestBody Map<String,String> map, HttpSession session){
        String phone = map.get("phone");
        String code = SmsUtil.SendSMS(phone);
        session.setAttribute("code",code);
    }

    @RequestMapping("/findAlluser")
    public ExUser findAlluser(@RequestBody Map<String,String> map){
        String id =map.get("id");
        System.out.println(id);
        ExUser list=loginService.findAlluser(Integer.parseInt(id));
        System.out.println(list.toString());
        return list;
    }
}
