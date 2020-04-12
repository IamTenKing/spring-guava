package com.example.springlearn.controller;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jt
 * @date 2020-4-4
 */

@Data
public class ShareData {

    private  AtomicInteger num = new AtomicInteger(0);


    private static  ShareData shareData = new ShareData();

    private ShareData(){};

    public static ShareData getInstance(){
        return shareData;

    }




}
