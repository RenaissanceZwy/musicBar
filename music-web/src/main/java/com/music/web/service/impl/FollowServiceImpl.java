package com.music.web.service.impl;

import com.music.web.dao.FollowDao;
import com.music.web.entity.Follow;
import com.music.web.service.FollowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/4/29.
 */
@Service(value = "FollowService")
public class FollowServiceImpl implements FollowService{

    private static  final Logger logger = LoggerFactory.getLogger(FollowServiceImpl.class);

    @Autowired
    private FollowDao followDao;

    public boolean insertFollow(Follow follow) {
        int result = 0;
        try{
            result = followDao.insertSelective(follow);
        }catch (Exception e){
            logger.info("[FollowServiceImpl][insertFollow]follow:"+follow.toString()+e);
        }
        return result>0;
    }

    public boolean cancelFollow(Follow follow) {
        int result = 0;
        try{
            result = followDao.deleteFollow(follow);
        }catch (Exception e){
            logger.info("[FollowServiceImpl][cancelFollow]follow:"+follow.toString()+e);
        }
        return result>0;
    }

    public Follow selectFollow(Follow follow) {
        Follow result = null;
        try{
            result = followDao.selectFollow(follow);
        }catch (Exception e){
            logger.info("[FollowServiceImpl][selectFollow]follow:"+follow.toString()+e);
        }
        return result;
    }
}
