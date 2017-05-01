package com.music.web.service;

import com.music.web.entity.AlbumMusic;
import com.music.web.entity.Music;

import java.util.List;

/**
 * 歌单中包含的歌曲
 * Created by Administrator on 2017/4/29.
 */
public interface AlbumMusicService {

    //获取某个歌单包含的所有的歌曲
    List<Music> selectAlbumMusic(int aid);

    //将歌曲插入某个歌单中
    boolean insertAlbumMusic(int aid,String mids);

    //将某首歌曲从某个歌单中删除
    boolean deleteMusicFromAlbum(String ids);

    //获取某条记录
    AlbumMusic selectAlbumMusic(int aid ,int mid);


}
