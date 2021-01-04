package com.example.demo.service.resident.impl;

import com.example.demo.dao.resident.LoginMapper;
import com.example.demo.pojo.resident.ExUser;
import com.example.demo.service.resident.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;

    @Override
    public ExUser login(String userCode,String allName) {
        System.out.println(allName);
        ExUser euser=loginMapper.login(userCode);
        if(euser==null){
            Boolean b=addphon(userCode,allName);
            if (b==true){
                ExUser login = login(userCode,allName);
                return login;
            }
        }
        return euser;
    }

    @Override
    public ExUser findAlluser(Integer id) {
        return loginMapper.findAlluser(id);
    }

    private Boolean addphon(String userCode, String allName) {
        return loginMapper.addphon(userCode,allName);
    }
}
