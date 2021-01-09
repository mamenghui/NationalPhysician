package com.example.demo.controller.resident;

import com.example.demo.pojo.resident.gytResidentLogin;
import com.example.demo.service.resident.LoginService;
import com.example.demo.util.Aliyununtils;
import com.example.demo.util.SmsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.Map;
/*
* 居民端APP后台
* 登录Controller
* xiaoma
* */
@RestController
@RequestMapping("/resiDentLog")
public class LoginController {
    @Autowired
    private LoginService loginService;

    //登录
    @RequestMapping("/Reslogin")
    public gytResidentLogin Reslogin(@RequestBody Map<String,String> map, HttpSession session){
        String rdtLoginAccount = map.get("rdtLoginAccount");
        String verification = map.get("verification");
        String rdtLoginRealName = map.get("rdtLoginRealName");
        String rdtLoginIcon = map.get("rdtLoginIcon");
        gytResidentLogin Reslogin=loginService.Reslogin(rdtLoginAccount,rdtLoginRealName,rdtLoginIcon);
        String code =(String) session.getAttribute("code");
        code="1111";
        if(Reslogin.getRdtLoginAccount() != null && verification.equals(code)){
            session.setAttribute("phon",rdtLoginAccount);
            return Reslogin;
        }else {
            return Reslogin;
        }
    }
    //短信验证
    @RequestMapping("/authCode")
    public void authCode(@RequestBody Map<String,String> map, HttpSession session){
        String phone = map.get("phone");
        String code = SmsUtil.SendSMS(phone);
        session.setAttribute("code",code);
    }

    //信息回显
    @RequestMapping("/findloginId")
    public gytResidentLogin findloginId(@RequestBody Map<String,String> map){
        String rdtLoginId =map.get("id");
        gytResidentLogin list=loginService.findloginId(Integer.parseInt(rdtLoginId));
        return list;
    }
    //基本信息填写和修改
    @RequestMapping("updMessage")
    public Boolean updMessage(@RequestBody gytResidentLogin gytResidentLogin){
        int bool=loginService.updMessage(gytResidentLogin);
        boolean fals=false;
        if(bool!=0){
            fals=true;
        }
        return fals;
    }

    @RequestMapping("/uploadingIcon")
    public boolean updata(@RequestParam("file") MultipartFile file,gytResidentLogin gyt, HttpSession session){
        boolean falg=false;
        String Filename = file.getOriginalFilename();
        session.setAttribute("Filename",Filename);
        String s = Aliyununtils.uploadFileInputSteam(Filename, file);
        String url="https://"+s;
        gyt.setRdtLoginIcon(url);
        int bo=loginService.updata(url,gyt.getRdtLoginId());
        if(bo!=0){
            falg=true;

        }
        return falg;
    }

    public void tt(){

        System.out.println(111);
    }

}
