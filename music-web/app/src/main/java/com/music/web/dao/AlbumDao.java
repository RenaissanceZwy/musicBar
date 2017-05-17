package com.music.web.dao;

import com.music.web.entity.Album;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    //获取所有的歌单
    List<Album> selectAlbums();
    //获取所有的歌单
    List<Album> selectAlbumsByPage(@Param("offset") int offset, @Param("pageSize") int pageSize,
                                   @Param("name") String name);
}