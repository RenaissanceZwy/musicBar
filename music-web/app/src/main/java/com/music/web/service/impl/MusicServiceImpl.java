package com.music.web.service.impl;

import com.music.web.dao.MusicDao;
import com.music.web.entity.Music;
import com.music.web.entity.PlayNum;
import com.music.web.service.MusicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/11/16.
 */
@Service(value = "MusicService")
public class MusicServiceImpl implements MusicService {

    private static  final Logger logger = LoggerFactory.getLogger(MusicServiceImpl.class);

    @Autowired
    private MusicDao musicDao;

    public Music selectMusicBySongId(String songId) {
        Music music = null;
        try{
            music = musicDao.selectMusicBySongId(songId);
        }catch (Exception e){
            logger.error("[MusicServiceImpl][selectMusicBySongId]"+e.getLocalizedMessage() + ":" + e.getMessage(),e.getCause());
        }
        return music;
    }

    public boolean insertMusic(Music music) {
        int result = 0;
        try{
            result = musicDao.insertMusic(music);
        }catch (Exception e){
            logger.error("[MusicServiceImpl][insertMusic]"+e.getLocalizedMessage() + ":" + e.getMessage(),e.getCause());
        }
        return result>0?true:false;
    }

    public boolean updateMusicPlayNum(int playNum, String songId) {
        int result = 0;
        try{
            result = musicDao.updateMusicPlayNum(playNum,songId);
        }catch (Exception e){
            logger.error("[MusicServiceImpl][updateMusicPlayNum]"+e.getLocalizedMessage() + ":" + e.getMessage(),e.getCause());
        }
        return result>0?true:false;
    }

    public List<Music> selectMusicOrderByPlayNum(int total) {
        List<Music> musics = null;
        try{
            musics = musicDao.selectMusicOrderByPlayNum(total);
        }catch (Exception e){
            logger.error("[MusicServiceImpl][selectMusicOrderByPlayNum]"+e.getLocalizedMessage() + ":" + e.getMessage(),e.getCause());
        }
        return musics;
    }

    public List<Music> selectMusicOrderByCollect(int total) {
        List<Music> musics = null;
        try{
            musics = musicDao.selectMusicOrderByCollect(total);
        }catch (Exception e){
            logger.error("[MusicServiceImpl][selectMusicOrderByCollect]"+e.getLocalizedMessage() + ":" + e.getMessage(),e.getCause());
        }
        return musics;
    }

    public boolean updateMusicPlayNum(PlayNum playNum) {
        int result = 0;
        try{
            PlayNum playNum1 = musicDao.selectMusciPlayNumByUid(playNum);
            if(null == playNum1){
                 playNum.setNum(1);
                 result = musicDao.insertMusicPlayNum(playNum);
            }else{
                 playNum1 = musicDao.selectMusciPlayNumByUid(playNum);
                 playNum.setNum(playNum1.getNum()+1);
                 result = musicDao.updateMusicPlayNumByUid(playNum);
            }
        }catch (Exception e){
            logger.error("[MusicServiceImpl][updateMusicPlayNum]"+e.getLocalizedMessage() + ":" + e.getMessage(),e.getCause());
        }
        return result>0;
    }

    public List<PlayNum> selectMusicPlayNum() {
        List<PlayNum> playNum = null;
        try{
            playNum = musicDao.selectPlayNum();
        }catch (Exception e){
            logger.error("[MusicServiceImpl][selectMusicNum]"+e.getLocalizedMessage() + ":" + e.getMessage(),e.getCause());
        }
        return playNum;
    }

    public int selectTotalPlayNumByUid(int uid) {
        int result = 0;
        try{
            result = musicDao.selectTotalMusicPlayNum(uid);
        }catch (Exception e){
            logger.error("[MusicServiceImpl][selectTotalPlayNumByUid]"+e.getLocalizedMessage() + ":" + e.getMessage(),e.getCause());
        }
        return result;
    }
}
