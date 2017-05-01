package com.music.web.service.impl;

import com.music.web.dao.LabelDao;
import com.music.web.service.LabelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/4/29.
 */
@Service(value = "LabelService")
public class LabelServiceImpl implements LabelService {

    private static  final Logger logger = LoggerFactory.getLogger(LabelServiceImpl.class);

    @Autowired
    private LabelDao labelDao;
}
