package com.music.web.dao;

import com.music.web.entity.AlbumMusic;
import com.music.web.entity.Music;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumMusicDao {
    int deleteByPrimaryKey(Integer id);

    int insert(AlbumMusic record);

    int insertSelective(AlbumMusic record);

    AlbumMusic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AlbumMusic record);

    int updateByPrimaryKey(AlbumMusic record);

    //获取某个专辑下面的音乐
    List<Music> selectAlbumMusic(int aid);

    //批量删除专辑下面的音乐
    int deleteBatchAlbumMusic(String[] ids);

    //批量新增专辑下面的音乐
    int insertBatchAlbumMusic(int aid,String mid);

    //判断某条记录是否存在
    AlbumMusic selectRecord(int aid ,int mid);
}