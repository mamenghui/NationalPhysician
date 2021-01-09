package com.example.demo.service.resident.impl;

import com.example.demo.dao.resident.LoginMapper;
import com.example.demo.pojo.resident.ExUser;
import com.example.demo.pojo.resident.gytResident;
import com.example.demo.pojo.resident.gytResidentLogin;
import com.example.demo.service.resident.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;


    @Transactional
    @Override
    public gytResidentLogin Reslogin(String rdtLoginAccount, String rdtLoginRealName,String rdtLoginIcon) {
        gytResidentLogin gyt =new gytResidentLogin();
        gytResident gys=new gytResident();
        gytResidentLogin Res=loginMapper.Reslogin(rdtLoginAccount);
        if(Res==null){
            int i=addred(gys);
            gyt.setRdtLoginResidentId(gys.getRdtId());
            Boolean b=addphon(rdtLoginAccount,rdtLoginRealName,gyt.getRdtLoginResidentId());
            if (b==true){
                gytResidentLogin login = Reslogin(rdtLoginRealName,rdtLoginRealName,rdtLoginIcon);
                return login;
            }
        }
        return Res;
    }

    @Transactional
    public int addred(gytResident gys) {
        return loginMapper.addred(gys);
    }

    @Transactional
    public Boolean addphon(String rdtLoginAccount, String rdtLoginRealName,Integer rdtLoginResidentId) {
        return loginMapper.addphon(rdtLoginAccount,rdtLoginRealName,rdtLoginResidentId);
    }

    @Override
    public gytResidentLogin findloginId(Integer rdtLoginId) {
        return loginMapper.findloginId(rdtLoginId);
    }

    @Transactional
    @Override
    public int updMessage(gytResidentLogin gytResidentLogin) {
        int glo=loginMapper.updMessage(gytResidentLogin);
        if(glo!=0){
            int gs=glologs(gytResidentLogin);
            return gs;
        }
        return glo;
    }

    @Override
    public int updata(String url, Integer id) {

        return loginMapper.updata(url,id);
    }

    @Transactional
    public int glologs(gytResidentLogin gytResidentLogin) {

        return loginMapper.glologs(gytResidentLogin);
    }

}
