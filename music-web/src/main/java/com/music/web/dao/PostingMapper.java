package com.music.web.dao;

import com.music.web.entity.Posting;

public interface PostingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Posting record);

    int insertSelective(Posting record);

    Posting selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Posting record);

    int updateByPrimaryKey(Posting record);
}