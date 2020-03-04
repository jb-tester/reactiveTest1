package com.mytests.spring.springData.mongo.reactive;

import com.mytests.spring.springData.mongo.reactive.configs.MongoConfig;
import com.mytests.spring.springData.mongo.reactive.services.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 4/17/2017.
 * Project: reactiveTest1
 * *******************************
 */
public class RunMe {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
        UserService service = ctx.getBean(UserService.class);
        service.findByAge();
        System.out.println("=============");
        service.findByRefs();
        System.out.println("=============");
        service.findByName();
        System.out.println("=============");
    }

}