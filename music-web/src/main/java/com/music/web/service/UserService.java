package com.music.web.service;

import com.music.web.entity.User;

import java.util.List;

/**
 * Created by zhaowenyi on 2016/11/15.
 */
public interface UserService {

    //获取所有的用户
    public List<User> getAllUsers();

    /*获取用户名的个数*/
    public int getCountOfName( String username);

    /*新建用户*/
    public boolean insertUser(User user);

    /* 判断用户是否存在*/
    public User getUserByUser( String username,String password);

    /*修改用户信息*/
    public boolean modifyUserInfo(User user);
/*
    将用户禁用和启用*/
    public boolean modifyUserSatsu(Long uid,int status);

    /* 通过用户id获取用户*/
    public User getUserById(String id);
}
