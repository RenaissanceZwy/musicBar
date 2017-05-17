package com.music.web.service;

import com.music.web.entity.Album;

import java.util.List;

/**
 * Created by Administrator on 2017/4/29.
 */
public interface AlbumService {

    //获取歌单的信息
    Album selectAlbumInfo(int aid);

    //获取歌单的信息
    Album selectAlbumInfo(String name);

    //新建歌单
    boolean insertAlbum(Album album);

    //删除歌单
    boolean deleteAlbum(int aid);

    List<Album> selectAllAlbums();

    //分页
    List<Album> selectAllAlbums(int pageNum,int pageSize,String name);
}
