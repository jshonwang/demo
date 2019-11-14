package com.example.demo.model;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
@EntityScan
public class UserInfo {
    /**
     * 用户id
     */
    private Long userId;
    private String username;
    private String emailAddress;
    private String registAddress;
    private String area;
    private String net;
    private String phoneNumber;
    private String ip;
    private String registTime;
    private String sex;
    private String loginTime;
}
