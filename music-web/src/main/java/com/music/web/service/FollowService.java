package com.music.web.service;

import com.music.web.entity.Follow;

/**
 * 用户关注相关
 * Created by Administrator on 2017/4/29.
 */
public interface FollowService {

    //进行关注操作
    boolean insertFollow(Follow follow);
    //进行取消关注操作
    boolean cancelFollow(Follow follow);
    //获取某条记录
    Follow selectFollow(Follow follow);
}
