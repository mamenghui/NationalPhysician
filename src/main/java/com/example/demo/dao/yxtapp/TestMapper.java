package com.example.demo.dao.yxtapp;

import com.example.demo.pojo.yxtapp.GytDoctorInfo;
import com.example.demo.pojo.yxtapp.GytDoctorLogin;

import org.apache.ibatis.annotations.Param;

public interface TestMapper {

    GytDoctorLogin getDoctorLogin(@Param("phone") String phone);

    Integer addDoctorLoginReg(@Param("phone") String phone, @Param("phone2") String phone2);

    Integer creatDoctorInfo(@Param("id") Integer id);

    Integer setDocForeignKey(@Param("id1") Integer id1, @Param("id2") Integer id2);

    GytDoctorInfo getDoctorInformation(@Param("id") Integer id);

    Integer updTouXiang(@Param("url") String url, @Param("id") Integer id);

    String getTouXiang(@Param("id") Integer id);

    Integer updDoctorLogin(GytDoctorInfo gytDoctorInfo);

    Integer updDoctorInfo(GytDoctorInfo gytDoctorInfo);
}
