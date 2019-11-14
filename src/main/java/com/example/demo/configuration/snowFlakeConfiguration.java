package com.example.demo.configuration;

import com.example.demo.utils.SnowFlakeUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class snowFlakeConfiguration {
    @Value("${mechineid}")
    public Long mechineNo;
    @Value("${projectid}")
    public Long projectNo;
    public String remak;

    @Bean
    public SnowFlakeUtil getInstence(){
        return new SnowFlakeUtil(mechineNo,projectNo);

    }

}
