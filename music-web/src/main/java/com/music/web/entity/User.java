package com.music.web.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/11/15.
 */
public class User implements Serializable{

    private static final long serialVersionUID = 1L;

    private Long id;
    private  String username;
    private String password;
    private  String email;
    private String headImg;
    private String sex;
    private int age;
    private int status;

    public User() {
    }

    public User(String username, String password, String email, String headImg, String sex, int age, int status) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.headImg = headImg;
        this.sex = sex;
        this.age = age;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", headImg='" + headImg + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", status=" + status +
                '}';
    }
}
