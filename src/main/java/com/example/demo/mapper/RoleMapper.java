package com.example.demo.mapper;

import com.example.demo.model.UserAuto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {
    public List<String>  queryRoleCodeByUsername(String username);

    public UserAuto loginAuth(String username,String password);

    UserAuto selectOneUserAuth(String userName);

}
