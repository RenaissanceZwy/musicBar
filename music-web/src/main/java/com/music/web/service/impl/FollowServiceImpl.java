package com.music.web.service.impl;

import com.music.web.dao.FollowDao;
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
}
