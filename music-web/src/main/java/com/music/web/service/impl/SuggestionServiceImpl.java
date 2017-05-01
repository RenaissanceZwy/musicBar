package com.music.web.service.impl;

import com.music.web.dao.SuggestionDao;
import com.music.web.service.SuggestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhoawenyi on 2017/4/29.
 */
@Service(value = "SuggestionService")
public class SuggestionServiceImpl implements SuggestionService{

    private static  final Logger logger = LoggerFactory.getLogger(SuggestionServiceImpl.class);

    @Autowired
    private SuggestionDao suggestionDao;
}
