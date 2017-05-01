package com.music.web.service;

import com.music.web.entity.Album;

/**
 * Created by Administrator on 2017/4/29.
 */
public interface AlbumService {

    //获取歌单的信息
    Album selectAlbumInfo(int aid);

    //新建歌单
    boolean insertAlbum(Album album);

    //删除歌单
    boolean deleteAlbum(int aid);
}
