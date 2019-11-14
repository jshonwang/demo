package com.example.demo.service.impl;

import com.example.demo.configuration.snowFlakeConfiguration;
import com.example.demo.mapper.UserManagerDao;
import com.example.demo.model.UserInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UserManagerServiceImpl implements UserManagerService{
    @Autowired
    private UserManagerDao userManagerDao;
    @Autowired
    private snowFlakeConfiguration snowFlakeConfiguration;
    @Override
    public PageInfo<UserInfo> getUserInfoList(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<UserInfo> listResult = userManagerDao.selectList();
        PageInfo<UserInfo> pageInfo = new PageInfo<>(listResult);
        return pageInfo;

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveUserInfo(UserInfo userInfo) throws Exception {

        UserInfo userInfo1 = userManagerDao.selectOneUser(userInfo.getUsername());
        Long userid = snowFlakeConfiguration.getInstence().nextId();
        userInfo.setUserId(userid);

        if(!(userInfo1==null)){
            throw new Exception("已经注册过。。。");
        }
        return userManagerDao.insertUserInfo(userInfo);
    }

    @Override
    @Transactional
    public int deleteUserByName(String username) throws Exception {
        int recount = userManagerDao.deleteUserByName(username);
        return recount;
    }
}
