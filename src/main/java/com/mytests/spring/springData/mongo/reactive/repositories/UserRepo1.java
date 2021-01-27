package com.mytests.spring.springData.mongo.reactive.repositories;

import com.mytests.spring.springData.mongo.reactive.data.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 4/17/2017.
 * Project: reactiveTest1
 * *******************************
 */
public interface UserRepo1 extends ReactiveCrudRepository<User, BigInteger> {
    Flux<User> findByAgeBetween(int age, int age2);
    Flux<User> findByReferencesContaining(Flux<String> references);
    Mono<User> getFirstByName(Mono<String> name);
    Mono<Boolean> existsByAgeGreaterThan(int ager);
}
