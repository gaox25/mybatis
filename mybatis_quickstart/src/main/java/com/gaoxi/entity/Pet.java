package com.gaoxi.entity;

public class Pet {
    /*
     CREATE TABLE `mybatis_pet`
      (id INT PRIMARY KEY AUTO_INCREMENT,
       nickname VARCHAR(32) NOT NULL DEFAULT '',
       user_id INT,
       FOREIGN KEY(user_id) REFERENCES mybatis_user(id)
      )CHARSET=utf8
     */
    private Integer id;
    private String nickname;
    private Integer userId;
    //一个Pet对应一个主人UserOfPets
    private UserOfPets user;

    public Pet() {
    }

    public Pet(Integer id, String nickname, Integer userId, UserOfPets user) {
        this.id = id;
        this.nickname = nickname;
        this.userId = userId;
        this.user = user;
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

    public UserOfPets getUser() {
        return user;
    }

    public void setUser(UserOfPets user) {
        this.user = user;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", userId=" + userId +
                ", user=" + user +
                '}';
    }
}
