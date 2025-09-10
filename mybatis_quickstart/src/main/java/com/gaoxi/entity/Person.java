package com.gaoxi.entity;

public class Person {
    /*
     CREATE TABLE person
     (id INT PRIMARY KEY AUTO_INCREMENT,
      `name` VARCHAR(32) NOT NULL DEFAULT '',
      card_id INT,
      FOREIGN KEY (card_id) REFERENCES idencard(id)
      )CHARSET utf8
     */
    private Integer id;
    private String name;
    //因为需要实现一个级联操作，一个Person需要对应一个IdenCard
    //这里需要直接配置/定义一个IdenCard
    private IdenCard card;

    public Person() {
    }

    public Person(Integer id, String name, IdenCard card) {
        this.id = id;
        this.name = name;
        this.card = card;
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

    public IdenCard getCard() {
        return card;
    }

    public void setCard(IdenCard card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", card=" + card +
                '}';
    }
}
