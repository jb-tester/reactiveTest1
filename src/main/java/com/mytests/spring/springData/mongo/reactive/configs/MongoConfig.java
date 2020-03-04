package com.mytests.spring.springData.mongo.reactive.configs;

import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.SimpleReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 4/17/2017.
 * Project: reactiveTest1
 * *******************************
 */
@Configuration
@EnableReactiveMongoRepositories(reactiveMongoTemplateRef = "template", basePackages = "com.mytests.spring.springData.mongo.reactive.repo*")
@ComponentScan("com.mytests.spring.springData.mongo.reactive.services")
public class MongoConfig {

    public @Bean ReactiveMongoDatabaseFactory mongoDatabaseFactory() {
        return new SimpleReactiveMongoDatabaseFactory(MongoClients.create(), "rdb1");
    }

    public @Bean ReactiveMongoTemplate template() {
        return new ReactiveMongoTemplate(mongoDatabaseFactory());
    }

}
