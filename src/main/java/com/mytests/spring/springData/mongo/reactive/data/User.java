package com.mytests.spring.springData.mongo.reactive.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.util.List;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 4/17/2017.
 * Project: reactiveTest1
 * *******************************
 */
@Document
public class User {

    @Id
    BigInteger id;
    String name;
    int age;
    List<String> references;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getReferences() {
        return references;
    }

    public void setReferences(List<String> references) {
        this.references = references;
    }

    public User(String name, int age, List<String> references) {
        this.name = name;
        this.age = age;
        this.references = references;
    }

    @Override
    public String toString() {
        return "User: " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", references=" + references +
                ' ';
    }
}
