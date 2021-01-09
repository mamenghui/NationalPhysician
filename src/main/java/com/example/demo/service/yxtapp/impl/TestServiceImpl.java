package com.example.demo.service.yxtapp.impl;

import com.example.demo.dao.yxtapp.TestMapper;
import com.example.demo.pojo.yxtapp.GytDoctorLogin;
import com.example.demo.service.yxtapp.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper testMapper;

    @Override
    public GytDoctorLogin getDoctorLogin(String phone) {

        return testMapper.getDoctorLogin(phone);
    }

    @Override
    public Integer addDoctorLoginReg(String phone) {
        /*
        * 这里要加事务的
        * */

       testMapper.addDoctorLoginReg(phone,phone);

       //获取到登录注册的id，设置为医生个人详细信息表的id
       GytDoctorLogin doctorLogin = testMapper.getDoctorLogin(phone);
        //先给外键的位置设置上
        doctorLogin.setDocLoginDoctorId(doctorLogin.getDocLoginId());
        Integer integer = testMapper.creatDoctorInfo(doctorLogin.getDocLoginId());

        testMapper.setDocForeignKey(doctorLogin.getDocLoginId(),doctorLogin.getDocLoginId());

        return integer;
    }
}
