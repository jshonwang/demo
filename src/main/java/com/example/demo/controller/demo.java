package com.example.demo.controller;

import com.example.demo.utils.ResultDto;

public class demo {
    public static void main(String[] args) {
        int count = 11;
        int pageSize = 5;
        int pageNumcount = count%pageSize==0?count/pageSize:count/pageSize+1;
        System.out.println(pageNumcount);
        ResultDto resultDto = new ResultDto();
        System.out.println(resultDto.setPageNumIs(10).getPageNum());

    }
}
