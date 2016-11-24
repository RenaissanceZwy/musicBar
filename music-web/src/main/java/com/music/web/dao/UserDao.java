package com.music.web.dao;

import com.music.web.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2016/11/16.
 */
@Repository
public interface UserDao {

    /*获取所有的用户*/
    public List<User> selectAllUsers();

    /*获取用户名的个数*/
    public int selectCountOfName(@Param("username") String username);

    /*新建用户*/
    public int insertUser(@Param("user") User user);

   /* 判断用户是否存在*/
    public User selectUserByUser(@Param("username") String username,@Param("password")  String password);
/*
    修改用户信息*/
    public int updateUser(@Param("user") User user);

    /*将用户禁用/启用*/
    public int updateUserStauts(@Param("uid") Long uid,@Param("status") int status);

 }
