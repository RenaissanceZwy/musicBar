package com.music.web.service;

import com.music.web.entity.Singer;

/**
 * 歌手相关
 * Created by Administrator on 2017/4/29.
 */
public interface SingerService {
    //创建歌手
    boolean insertSinger(Singer singer);
    //获取歌手
    Singer selectSinger(int id);
    //删除歌手
    boolean deleteSinger(int id);
}
