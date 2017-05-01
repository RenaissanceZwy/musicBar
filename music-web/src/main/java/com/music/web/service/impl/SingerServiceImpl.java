package com.music.web.service.impl;

import com.music.web.dao.SingerDao;
import com.music.web.service.SingerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/4/29.
 */
@Service(value = "SingerService")
public class SingerServiceImpl implements SingerService {

    private static  final Logger logger = LoggerFactory.getLogger(SingerServiceImpl.class);

    @Autowired
    private SingerDao singerDao;
}
