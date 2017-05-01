package com.music.web.service.impl;

import com.music.web.dao.AlbumDao;
import com.music.web.entity.Album;
import com.music.web.service.AlbumService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/4/29.
 */
@Service(value = "AlbumService")
public class AlbumServiceImpl implements AlbumService {

    private static  final Logger logger = LoggerFactory.getLogger(AlbumService.class);

    @Autowired
    private AlbumDao albumDao;

    public Album selectAlbumInfo(int aid) {
        Album album = null;
        try{
            album = albumDao.selectByPrimaryKey(aid);
        }catch (Exception e){
            logger.info("[AlbumServiceImpl][selectAlbumInfo]aid:"+aid+e);
        }
        return album;
    }

    public boolean insertAlbum(Album album) {
        int result = 0;
        try{
            result = albumDao.insertSelective(album);
        }catch (Exception e){
            logger.info("[AlbumServiceImpl][insertAlbum ]album:"+album.toString()+e);
        }
        return result>0;
    }

    public boolean deleteAlbum(int aid) {
        int result = 0;
        try{
            result = albumDao.deleteByPrimaryKey(aid);
        }catch (Exception e){
            logger.info("[AlbumServiceImpl][deleteAlbum] aid:"+aid+e);
        }
        return result>0;
    }
}
