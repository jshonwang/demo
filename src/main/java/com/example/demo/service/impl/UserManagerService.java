package com.example.demo.service.impl;

import com.example.demo.model.UserInfo;
import com.example.demo.model.UserView;
import com.github.pagehelper.PageInfo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
@Service
public interface UserManagerService {
    public PageInfo getUserInfoList(int pageNum, int pageSize);

    public int saveUserInfo(UserInfo userInfo) throws Exception;

    public int deleteUserByName(String username) throws Exception;
    public UserDetails getUserDetailByUserName(String username);

    public UserView getUserByUserName(String username);

    public  boolean loginLogin(String username,String password);

}
