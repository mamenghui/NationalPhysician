package com.example.demo.service.yxtapp;


import com.example.demo.pojo.yxtapp.GytDoctorLogin;

public interface TestService {

    GytDoctorLogin getDoctorLogin(String phone);

    Integer addDoctorLoginReg(String phone);
}
