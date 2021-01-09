package com.example.demo.service.yxtapp.impl;


import com.example.demo.dao.yxtapp.TestMapper;
import com.example.demo.pojo.yxtapp.GytDoctorInfo;
import com.example.demo.service.yxtapp.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoServiceImpl implements InfoService {

    @Autowired
    private TestMapper testMapper;


    @Override
    public GytDoctorInfo getDoctorInformation(Integer id) {
        return testMapper.getDoctorInformation(id);
    }

    @Override
    public Integer updTouXiang(String url, Integer id) {
        return testMapper.updTouXiang(url,id);
    }

    @Override
    public String getTouXiang(Integer id) {
        return testMapper.getTouXiang(id);
    }

    @Override
    public Integer updDoctorLogin(GytDoctorInfo gytDoctorInfo) {
        return testMapper.updDoctorLogin(gytDoctorInfo);
    }

    @Override
    public Integer updDoctorInfo(GytDoctorInfo gytDoctorInfo) {
        return testMapper.updDoctorInfo(gytDoctorInfo);
    }
}
