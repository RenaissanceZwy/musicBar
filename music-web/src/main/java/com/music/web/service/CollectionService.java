package com.music.web.service;

import com.music.web.entity.CollectionMusic;
import com.music.web.entity.Music;

import java.util.List;

/**
 * Created by Administrator on 2016/11/16.
 */
public interface CollectionService {

    /*获取某个用户的收藏*/
    public List<Music> selectMusicByUser(Long uid, int type);

    public boolean checkCollectionExist(Long mid,Long uid, int type);

    /* 进行插入收藏操做*/
    public boolean insertCollection(CollectionMusic collectionMusic);

    /* 进行删除操做*/
    public boolean deleteCollection( Long mid,Long uid, int type);
}

