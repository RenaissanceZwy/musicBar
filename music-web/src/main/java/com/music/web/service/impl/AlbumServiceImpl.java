package com.music.web.service.impl;

import com.music.web.dao.AlbumDao;
import com.music.web.service.AlbumService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/4/29.
 */
@Service(value = "AlbumService")
public class AlbumServiceImpl implements AlbumService {

    private static  final Logger logger = LoggerFactory.getLogger(AlbumService.class);

    @Autowired
    private AlbumDao albumDao;

}
