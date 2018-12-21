package com.example.demoh2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class BootStrapDB implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private DBInit dbInit;


    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        dbInit.dbInit();
    }
}
