package com.music.web.dao;

import com.music.web.entity.Suggestion;
import org.springframework.stereotype.Repository;

@Repository
public interface SuggestionDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Suggestion record);

    int insertSelective(Suggestion record);

    Suggestion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Suggestion record);

    int updateByPrimaryKey(Suggestion record);
}