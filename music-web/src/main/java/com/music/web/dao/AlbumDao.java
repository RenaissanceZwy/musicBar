package com.music.web.dao;

import com.music.web.entity.Album;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Album record);

    int insertSelective(Album record);

    Album selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Album record);

    int updateByPrimaryKey(Album record);

    //通过名称获取歌单
    Album selectByName(String name);
}