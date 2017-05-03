package com.music.web.dao;

import com.music.web.entity.Suggestion;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuggestionDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Suggestion record);

    int insertSelective(Suggestion record);

    Suggestion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Suggestion record);

    int updateByPrimaryKey(Suggestion record);

    List<Suggestion> selectSuggestions();
}