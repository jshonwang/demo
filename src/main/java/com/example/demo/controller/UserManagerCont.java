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
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
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
    public ResultDto selectUserInfos(HttpServletRequest request,   Integer pageNum,Integer pageSize){
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
    public ResultDto removeUer(@RequestParam("username") String username) throws Exception {
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
    @RequestMapping("/upload")
    public ResultDto upload(List<MultipartFile>  file) throws IOException {
        if(file.size()<=0){
            return new ResultDto().FAIL("上传文件为空");
        }
        for(MultipartFile filesele:file){
            String uploadFileName = filesele.getOriginalFilename();
            String path = "F:/test";
            File dest = new File(path+"/"+uploadFileName);
            if(!dest.getParentFile().exists()){
                dest.getParentFile().mkdir();
            }
            filesele.transferTo(dest);
        }
        return new ResultDto().SUCCESS("上传成功");


    }

}
