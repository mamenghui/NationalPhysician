package com.example.demo.service.resident;

import com.example.demo.pojo.resident.ExUser;
import com.example.demo.pojo.resident.gytResidentLogin;

public interface LoginService {
    gytResidentLogin Reslogin(String rdtLoginAccount, String rdtLoginRealName,String rdtLoginIcon);

    gytResidentLogin findloginId(Integer rdtLoginId);

    int updMessage(gytResidentLogin gytResidentLogin);

    int updata(String url, Integer id);
}
