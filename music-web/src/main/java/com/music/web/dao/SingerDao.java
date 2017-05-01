package com.music.web.dao;

import com.music.web.entity.Singer;
import org.springframework.stereotype.Repository;

@Repository
public interface SingerDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Singer record);

    int insertSelective(Singer record);

    Singer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Singer record);

    int updateByPrimaryKey(Singer record);
}