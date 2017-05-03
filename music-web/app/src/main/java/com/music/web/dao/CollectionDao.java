package com.music.web.dao;

import com.music.web.entity.CollectionMusic;
import com.music.web.entity.Music;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zahowenyi on 2016/11/16.
 */
@Repository
public interface CollectionDao {

    /*获取某个用户的收藏*/
    public List<Music> selectMusicByUser(@Param("uid") Integer uid, @Param("type") int type);

    /*1 音乐收藏 2 歌手收藏 3 歌单收藏 4 音乐喜爱*/
    public List selectByUser(@Param("uid") Integer uid, @Param("type") int type);

    public int selecCollectionCountByUidAndMid(@Param("mid") Long mid,@Param("uid") Integer uid,@Param("type") int type);

    /* 进行插入收藏操做*/
    public int insertCollection(@Param("collect")CollectionMusic collectionMusic);

   /* 进行删除操做*/
    public int deleteCollection(@Param("mid") Long mid,@Param("uid") Integer uid,@Param("type") int type);



}
