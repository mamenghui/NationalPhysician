package com.example.demo.dao.resident;

import com.example.demo.pojo.resident.ExUser;
import com.example.demo.pojo.resident.gytResident;
import com.example.demo.pojo.resident.gytResidentLogin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface LoginMapper {
    
    gytResidentLogin Reslogin(@Param("rdtLoginAccount") String rdtLoginAccount);

    Boolean addphon(@Param("rdtLoginAccount")String rdtLoginAccount,@Param("rdtLoginRealName") String rdtLoginRealName,@Param("rdtLoginResidentId")Integer rdtLoginResidentId);

    int addred(gytResident gys);

    gytResidentLogin findloginId(@Param("rdtLoginId")Integer rdtLoginId);

    int updMessage(gytResidentLogin gytResidentLogin);

    int glologs(gytResidentLogin gytResidentLogin);

    int updata(@Param("url")String url,@Param("id") Integer id);
}
