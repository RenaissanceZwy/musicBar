package com.music.web.service;

import com.music.web.entity.Suggestion;

import java.util.List;

/**
 * 建议相关
 * Created by Administrator on 2017/4/29.
 */
public interface SuggestionService {

    //新建建议
    boolean insertSuggestion(Suggestion suggestion);
    //获取所有的建议
    List<Suggestion> selectSuggestions();
}
