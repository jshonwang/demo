package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.UserInfo;
import com.example.demo.service.impl.UserManagerService;
import com.example.demo.utils.CodeSys;
import com.example.demo.utils.ResultDto;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserManagerCont {
    @Autowired
    private UserManagerService userManagerService;

    public static Logger logger = LoggerFactory.getLogger(UserManagerCont.class);
    public StringBuilder stringBuilder = new StringBuilder();
    public static final int pageSizeC = 5;
    @RequestMapping("/save")
    public String saveUserInfo(){
        return "";
    }
    @RequestMapping("/select")
    public ResultDto selectUserInfos(HttpServletRequest request,  @RequestParam("page") Integer pageNum, @RequestParam("limit") Integer pageSize){
        if(pageSize==null||pageSize.intValue()<1){
            pageSize = pageSizeC;
        }
        stringBuilder.append("查询用户信息------>");
        logger.info(stringBuilder.toString());
        stringBuilder.delete(0,stringBuilder.length());
        PageInfo<UserInfo> pageResult = userManagerService.getUserInfoList(pageNum,pageSize);
        ResultDto resultDto = new ResultDto(CodeSys.SUCCESS,CodeSys.SUCCESSMESSAGE,pageResult.getList());
        resultDto.setCount(pageResult.getTotal());
        logger.info(stringBuilder.append("查询结束").toString());
        String jsonString = JSONObject.toJSONString(resultDto);
        JSONObject jsonObject = JSON.parseObject(jsonString);
        List<UserInfo> listR = (List<UserInfo>)jsonObject.get("data");


        for(UserInfo userInfo: listR){
            if(!(userInfo==null)){

            }
        }


        return resultDto;
    }

    @RequestMapping("/login")
    public ResultDto loginCheck(@RequestBody UserInfo userInfo){
        String username = userInfo.getUsername();
        String password = userInfo.getUsername();


        return  new ResultDto().SUCCESS("成功");

    }
    @RequestMapping("/regist")
    public ResultDto RegistUserInfo(@RequestBody UserInfo userInfo){
        if(userInfo==null||userInfo.getUsername().isEmpty()||userInfo.getEmailAddress().isEmpty()){
            return new ResultDto(CodeSys.FAIL,"请求参数有误请检查",null);
        }
        try {
            userManagerService.saveUserInfo(userInfo);
            return new ResultDto().SUCCESS('s');
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ResultDto(CodeSys.FAIL,e.getMessage(),null);
        }

    }
    @RequestMapping("/remove")
    public ResultDto removeUer(String username) throws Exception {
        if(username.isEmpty()){
            return new ResultDto().FAIL("用户名传值为空");

        }
        userManagerService.deleteUserByName(username);
        return new ResultDto().SUCCESS("删除成功");
    }
    @RequestMapping("/update")
    public ResultDto updateUserInfo(UserInfo userInfo){
        //
        return null;
    }

}
