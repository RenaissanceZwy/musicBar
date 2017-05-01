package com.music.web.service.impl;

import com.music.web.dao.AlbumMusicDao;
import com.music.web.service.AlbumMusicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/4/29.
 */
@Service(value = "AlbumMusicService")
public class AlbumMusicServiceImpl implements AlbumMusicService {

    private static  final Logger logger = LoggerFactory.getLogger(AlbumMusicServiceImpl.class);

    @Autowired
    private AlbumMusicDao albumMusicDao;



}
