package com.mytests.spring.springData.mongo.reactive.services;

import com.mytests.spring.springData.mongo.reactive.data.User;
import com.mytests.spring.springData.mongo.reactive.repositories.UserRepo1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 4/17/2017.
 * Project: reactiveTest1
 * *******************************
 */
@Service
public class UserService {

    @Autowired
    private ReactiveMongoOperations operations;

    @Autowired
    private UserRepo1 userRepo1;

    public void setUp(){
        List<String> ref1 = new ArrayList<>();
        ref1.add("reference11");
        ref1.add("reference12");
        ref1.add("reference13");
        List<String> ref2 = new ArrayList<>();
        ref2.add("reference21");
        ref2.add("reference22");
        ref2.add("reference23");
        List<String> ref3 = new ArrayList<>();
        ref3.add("reference31");
        ref3.add("reference32");
        ref3.add("reference33");
        User user1 = new User("name1", 18, ref1);
        User user2 = new User("name2", 21, ref2);
        User user3 = new User("name3", 12, ref3);

        operations.collectionExists(User.class) //
                .flatMap(exists -> exists ? operations.dropCollection(User.class) : Mono.just(exists)) //
                .flatMap(o -> operations.createCollection(User.class, new CollectionOptions(1024 * 1024, 100, true))) //
                .then() //
                .block();
        userRepo1
                .save(Flux.just(user1, user2, user3)) //
                .then() //
                .block();


    }
    public void findAll(){
        setUp();
        List<User> allUsers = userRepo1.findAll().collectList().block();
        for(User u: allUsers){
            System.out.println(u.toString());
        }
    }
    public void findByAge(){
        setUp();
        Flux<User> users = userRepo1.findByAgeBetween(15,30);
        List<User> u = users.collectList().block();
        for (User user : u) {
            System.out.println(user);
        }
    }
    public void findByRefs(){
        setUp();
        Flux<String> refs = Flux.just("reference11");
        Flux<User> users = userRepo1.findByReferencesContaining(refs);
        List<User> u = users.collectList().block();
        for (User user : u) {
            System.out.println(user);
        }
    }
    public void findByName(){
        setUp();

        Mono<String> name = Mono.just("name3");
        User user = userRepo1.getFirstByName(name).block();
        System.out.println(user.toString());
    }

}
