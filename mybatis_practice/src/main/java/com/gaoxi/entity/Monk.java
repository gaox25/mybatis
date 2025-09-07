package com.gaoxi.entity;

import java.util.Date;

public class Monk {
    //属性
    /*
     使用包装类型，主要是出于以下三点需要：
     1.更好地融入Java生态，即面向对象的统一性
     2.解决null值处理的问题，因为基本类型无法表现null
     3.支持泛型
     */
    private Integer id;
    private String nickname;
    private String skill;
    private String grade;
    private Double salary;
    private Date birthday;
    private Date entry;

    public Monk() {
    }

    public Monk(Integer id, String nickname, String skill, String grade, Double salary, Date birthday, Date entry) {
        this.id = id;
        this.nickname = nickname;
        this.skill = skill;
        this.grade = grade;
        this.salary = salary;
        this.birthday = birthday;
        this.entry = entry;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getEntry() {
        return entry;
    }

    public void setEntry(Date entry) {
        this.entry = entry;
    }

    @Override
    public String toString() {
        return "Monk{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", skill='" + skill + '\'' +
                ", grade='" + grade + '\'' +
                ", salary=" + salary +
                ", birthday=" + birthday +
                ", entry=" + entry +
                '}';
    }
}
