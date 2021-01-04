package com.example.demo.service.resident;

import com.example.demo.pojo.resident.ExUser;

public interface LoginService {
    ExUser login(String userCode, String allName);

    ExUser findAlluser(Integer id);
}
