package com.example.demo.model;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
@EntityScan
public class RoleInfo {
    private String role_code;
    private String parent_role_code;
    private String role_desc;

}
