package com.music.web.service.impl;

import com.music.web.dao.AlbumMusicDao;
import com.music.web.entity.AlbumMusic;
import com.music.web.entity.Music;
import com.music.web.service.AlbumMusicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/4/29.
 */
@Service(value = "AlbumMusicService")
public class AlbumMusicServiceImpl implements AlbumMusicService {

    private static  final Logger logger = LoggerFactory.getLogger(AlbumMusicServiceImpl.class);

    @Autowired
    private AlbumMusicDao albumMusicDao;

    public List<Music> selectAlbumMusic(int aid) {
        List<Music> musics = null;
        try{
            musics = albumMusicDao.selectAlbumMusic(aid);
        }catch (Exception e){
            logger.info("[AlbumMusicServiceImpl][selectAlbumMusic]aid:"+aid+e);
        }
        return musics;
    }

    public boolean insertAlbumMusic(int aid, String mids) {
        int result = 0;
        try{
            String[] midStr = mids.split("\\|");
            result = albumMusicDao.insertBatchAlbumMusic(aid,midStr);
        }catch (Exception e){
            logger.info("[AlbumMusicServiceImpl][insertAlbumMusic]aid:"+aid+"mids:"+mids.toString()+e);
        }
        return result>0;
    }

    public boolean deleteMusicFromAlbum(String ids) {
        int result = 0;
        try{
            String[] midStr = ids.split("\\|");
             result = albumMusicDao.deleteBatchAlbumMusic(midStr);
        }catch (Exception e){
            logger.info("[AlbumMusicServiceImpl][insertAlbumMusic] mids:"+ids.toString()+e);
        }
        return result>0;
    }

    public AlbumMusic selectAlbumMusic(int aid, int mid) {
        AlbumMusic result = null;
        try{
            result = albumMusicDao.selectRecord(aid,mid);
        }catch (Exception e){
            logger.info("[AlbumMusicServiceImpl][insertAlbumMusic] mids:"+mid+"aid"+aid+e);
        }
        return result;
    }
}
