package com.gaoxi.entity;

import java.util.List;

public class UserOfPets {
    /**
     * CREATE TABLE `mybatis_user`
     * (id INT PRIMARY KEY AUTO_INCREMENT,
     * NAME VARCHAR(32) NOT NULL DEFAULT ''
     * )CHARSET=utf8
     */
    private Integer id;
    private String name;
    //作为一个User，可以对应多个宠物，mybatis使用集合体现这种多对一的关系
    private List<Pet> pets;

    public UserOfPets() {
    }

    public UserOfPets(Integer id, String name, List<Pet> pets) {
        this.id = id;
        this.name = name;
        this.pets = pets;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    //打印pets时，会调用pet的toString()方法，而pet的toString()方法会打印user对象，
    //这样会无限循环下去，此时会有StackOverFlow异常
//    @Override
//    public String toString() {
//        return "UserOfPets{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", pets=" + pets +
//                '}';
//    }
}
