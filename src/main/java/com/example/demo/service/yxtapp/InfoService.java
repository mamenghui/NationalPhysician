package com.example.demo.service.yxtapp;


import com.example.demo.pojo.yxtapp.GytDoctorInfo;

public interface InfoService {

    GytDoctorInfo getDoctorInformation(Integer id);

    Integer updTouXiang(String url, Integer id);

    String getTouXiang(Integer id);

    Integer updDoctorLogin(GytDoctorInfo gytDoctorInfo);

    Integer updDoctorInfo(GytDoctorInfo gytDoctorInfo);
}
