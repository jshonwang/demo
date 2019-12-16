package com.example.demo.service.impl;

import com.example.demo.Exception.BussinessException;
import com.example.demo.configuration.snowFlakeConfiguration;
import com.example.demo.mapper.RoleMapper;
import com.example.demo.mapper.UserManagerDao;
import com.example.demo.model.UserAuto;
import com.example.demo.model.UserInfo;
import com.example.demo.model.UserView;
import com.example.demo.utils.ResultDto;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserManagerServiceImpl implements UserManagerService{
    @Autowired
    private UserManagerDao userManagerDao;
    @Autowired
    private RoleMapper roleMapper;
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
        /*if(true){
            ResultDto resultDto = new ResultDto().FAIL("存数据失败");
            BussinessException exception = new BussinessException();
            exception.setResultDto(resultDto);
            throw exception;
        }*/

        UserInfo userInfo1 = userManagerDao.selectOneUser(userInfo.getUsername());
        Long userid = snowFlakeConfiguration.getInstence().nextId();
        userInfo.setUserId(userid);

        if(!(userInfo1==null)){
            throw new Exception("已经注册过。。。");
        }
        HashMap maop = new HashMap();
        String s = maop.get("wx").toString();


        return userManagerDao.insertUserInfo(userInfo);

    }

    @Override
    @Transactional
    public int deleteUserByName(String username) throws Exception {
        int recount = userManagerDao.deleteUserByName(username);
        return recount;
    }

    @Override
    @Transactional
    public UserView getUserByUserName(String userName){

        UserView userView = new UserView();
        UserAuto user = roleMapper.selectOneUserAuth(userName);
        userView.setUserName(user.getUserName());
        userView.setUserDesc(user.getUserDescription());
        List<String> roleCodes = new ArrayList<>();
        user.getRoles().stream().forEach(role -> roleCodes.add(role.getRole_code()));
        userView.setRoleCodes(roleCodes);
        return userView;
    }

    @Override
    public boolean loginLogin(String username, String password) {
        UserAuto u = roleMapper.loginAuth(username,password);
        if(u==null){
            return false;
        }
        return true;
    }

    @Override
    @Transactional
    public UserDetails getUserDetailByUserName(String username){

        UserAuto userAuto = roleMapper.selectOneUserAuth(username);

        if(userAuto == null){
            //throw exception inform front end not this user
            throw new UsernameNotFoundException("user + " + username + "not found.");
        }

        List<String> roleList = this.roleMapper.queryRoleCodeByUsername(username);
        List<GrantedAuthority> authorities = roleList.stream()
                .map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList());

        return new org.springframework.security.core.userdetails
                .User(username,userAuto.getPassword(),authorities);


    }
}
