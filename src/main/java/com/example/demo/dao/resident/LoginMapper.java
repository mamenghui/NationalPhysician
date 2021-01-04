package com.example.demo.dao.resident;

import com.example.demo.pojo.resident.ExUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface LoginMapper {

    ExUser login(@Param("userCode") String userCode);

    Boolean addphon(@Param("userCode") String userCode,@Param("allName")String allName);

    ExUser findAlluser(@Param("id") Integer id);
}
