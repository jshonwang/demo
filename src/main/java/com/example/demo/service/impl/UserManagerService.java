package com.example.demo.service.impl;

import com.example.demo.model.UserInfo;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserManagerService {
    public PageInfo getUserInfoList(int pageNum, int pageSize);

    public int saveUserInfo(UserInfo userInfo) throws Exception;

    public int deleteUserByName(String username) throws Exception;
}
