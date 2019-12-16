package com.example.demo.mapper;

import com.example.demo.model.UserAuto;
import com.example.demo.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserManagerDao {
    /**
     * 查询所有用户
     * @param
     * @return
     */
    List<UserInfo> selectList();
    /**
     * 查询条件用户
     * @param
     * @return
     */
    List<UserInfo> selectList1(List<String> param);
    /**
     * 查询特定用户
     * @param
     * @return
     */
    UserInfo selectOneUser(String userName);
    /**
     * 模糊查询用户
     * @param
     * @return
     */
    List<UserInfo>   selectUserLike(UserInfo userInfo);
    /**
     * 插入数据
     */
    int insertUserInfo(UserInfo userInfo);
    /**
     * 批量插入数据
     */
    int insertUserInfo(List<UserInfo> userinfoParams);

    /**
     * 删除
     * @param username
     * @return
     */
    int deleteUserByName(String username);


    UserAuto selectOneUserAuth(String userName);



}
