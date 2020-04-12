package com.example.springlearn.controller;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author jt
 * @date 2020-4-4
 */

@Component
public class MyComandLine implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        int andIncrement = ShareData.getInstance().getNum().getAndIncrement();
        System.out.println("commandlineRunner执行"+andIncrement);


    }
}
