package com.music.web.service.impl;

import com.music.web.dao.SuggestionDao;
import com.music.web.entity.Suggestion;
import com.music.web.service.SuggestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhoawenyi on 2017/4/29.
 */
@Service(value = "SuggestionService")
public class SuggestionServiceImpl implements SuggestionService{

    private static  final Logger logger = LoggerFactory.getLogger(SuggestionServiceImpl.class);

    @Autowired
    private SuggestionDao suggestionDao;

    public boolean insertSuggestion(Suggestion suggestion) {
        int result = 0;
        try{
            result = suggestionDao.insertSelective(suggestion);
        }catch (Exception e){
            logger.info("[SingerServiceImpl][insertSuggestion]suggestion:"+suggestion.toString()+e);
        }
        return result>0;
    }

    public List<Suggestion> selectSuggestions() {
        List<Suggestion> result = null;
        try{
            result = suggestionDao.selectSuggestions();
        }catch (Exception e){
            logger.info("[SingerServiceImpl][selectSuggestions]:"+e);
        }
        return result;
    }
}
