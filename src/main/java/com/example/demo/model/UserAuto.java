package com.example.demo.model;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.List;

@Data
@EntityScan
public class UserAuto {
    private String userName;
    private String userDescription;
    private String password;
    private List<RoleInfo> roles;
}
