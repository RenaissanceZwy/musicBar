package com.music.web.dao;

import com.music.web.entity.AlbumMusic;

public interface AlbumMusicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AlbumMusic record);

    int insertSelective(AlbumMusic record);

    AlbumMusic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AlbumMusic record);

    int updateByPrimaryKey(AlbumMusic record);
}