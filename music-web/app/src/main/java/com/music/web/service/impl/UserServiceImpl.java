package com.music.web.service.impl;

import com.music.web.dao.UserDao;
import com.music.web.entity.User;
import com.music.web.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/11/15.
 */
@Service(value = "UserService")
public class UserServiceImpl  implements UserService{

    private static  final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    public List<User> getAllUsers() {
        List<User> users = null;
        try{
            users = userDao.selectAllUsers();
        }catch (Exception e){
            logger.error("[UserServiceImpl][getAllUsers]"+e.getLocalizedMessage() + ":" + e.getMessage(),e.getCause());
        }
        return  users;
    }

    public int getCountOfName(String username) {
        int result = 0;
        try{
            result = userDao.selectCountOfName(username);
        }catch (Exception e){
            logger.error("[UserServiceImpl][getCountOfName]"+e.getLocalizedMessage() + ":" + e.getMessage(),e.getCause());
        }
        return result;
    }

    public boolean insertUser(User user) {
        int result = 0;
        try{
            result = userDao.insertUser(user);
        }catch (Exception e){
            logger.error("[UserServiceImpl][insertUser]"+e.getLocalizedMessage() + ":" + e.getMessage(),e.getCause());
        }
        return result>0?true:false;
    }

    public User getUserByUser(String username, String password) {
        User user = null;
        try{
            user = userDao.selectUserByUser(username,password);
        }catch (Exception e){
            logger.error("[UserServiceImpl][getUserByUser]"+e.getLocalizedMessage() + ":" + e.getMessage(),e.getCause());
        }
        return user;
    }

    public boolean modifyUserInfo(User user) {
        int result = 0;
        try{
            result = userDao.updateUser(user);
        }catch (Exception e){
            logger.error("[UserServiceImpl][modifyUserInfo]"+e.getLocalizedMessage() + ":" + e.getMessage(),e.getCause());
        }
        return result>0?true:false;
    }

    public boolean modifyUserSatsu(Long uid, int status) {
        int result = 0;
        try{
            result = userDao.updateUserStauts(uid,status);
        }catch (Exception e){
            logger.error("[UserServiceImpl][modifyUserSatsu]"+e.getLocalizedMessage() + ":" + e.getMessage(),e.getCause());
        }
        return result>0?true:false;
    }

    public User getUserById(String id) {
        User user = null;
        try{
            user = userDao.selectUserById(id);
        }catch (Exception e){
            logger.error("[UserServiceImpl][getUserById] id="+id+""+e);
        }
        return user;
    }
}
