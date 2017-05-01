package com.music.web.service.impl;

import com.music.web.dao.PostingDao;
import com.music.web.service.PostingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/4/29.
 */
@Service(value = "PostingService")
public class PostingServiceImpl implements PostingService {

    private static  final Logger logger = LoggerFactory.getLogger(PostingServiceImpl.class);

    @Autowired
    private PostingDao postingDao;
}
