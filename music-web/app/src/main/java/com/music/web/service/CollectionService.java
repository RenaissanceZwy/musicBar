package com.music.web.service;

import com.music.web.entity.CollectionMusic;
import com.music.web.entity.Music;

import java.util.List;

/**
 * Created by Administrator on 2016/11/16.
 */
public interface CollectionService {

    /*获取某个用户的收藏*/
    public List<Music> selectMusicByUser(Integer uid, int type);

    /* 1 音乐收藏 2 歌手收藏 3 歌单收藏 4 音乐喜爱*/
    public List selectByUser(Integer uid,int type);

    public boolean checkCollectionExist(Long mid,Integer uid, int type);

    /* 进行插入收藏操做*/
    public boolean insertCollection(CollectionMusic collectionMusic);

    /* 进行删除操做*/
    public boolean deleteCollection( Long mid,Integer uid, int type);
}

