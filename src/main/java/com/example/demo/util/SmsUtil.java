package com.example.demo.util;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

public class SmsUtil {
    //短信验证AccessKeyId在短信服务获取
    static final String  AccessKeyId="LTAI4FnzjsFKmrBeku32jBDj";
    //短信验证AccessKeySecret 密钥,
    static final String AccessKeySecret ="oKQBBvR2KjWt2sRCM9v8Jneq9Y2xTb";

    public  static String SendSMS(String phone){

        DefaultProfile profile = DefaultProfile.getProfile("cn-BeiJing", AccessKeyId, AccessKeySecret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();

        /*request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");*/
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-BeiJing");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "国医堂APP");
        request.putQueryParameter("TemplateCode", "SMS_184106306");
        String code = randomCode();
        System.out.println("发的验证码"+code);
        request.putQueryParameter("TemplateParam", "{\"code\":\""+code+"\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return code;
    }

    private static String randomCode() {
        Integer random =(int)(Math.random()*10000
        );
        return random.toString();
    }
}
