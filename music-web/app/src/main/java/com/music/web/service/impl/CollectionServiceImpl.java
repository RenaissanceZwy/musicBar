package com.music.web.service.impl;

import com.music.web.dao.CollectionDao;
import com.music.web.entity.CollectionMusic;
import com.music.web.entity.Music;
import com.music.web.service.CollectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.apache.ibatis.ognl.DynamicSubscript.mid;

/**
 * Created by Administrator on 2016/11/16.
 */
@Service(value = "CollectionService")
public class CollectionServiceImpl implements CollectionService {

    private static  final Logger logger = LoggerFactory.getLogger(CollectionServiceImpl.class);

    @Autowired
    private CollectionDao collectionDao;

    public List<Music> selectMusicByUser(Integer uid, int type) {
        List<Music> musics = null;
        try{
            musics = collectionDao.selectMusicByUser(uid,type);
        }catch (Exception e){
            logger.error("[CollectionServiceImpl][selectMusicByUser]:uid="+uid+"mid="+mid+e.getLocalizedMessage() + ":" + e.getMessage(),e.getCause());
        }
        return musics;
    }

    public List<Object> selectByUser(Integer uid, int type) {
        List<Object> musics = null;
        try{
            musics = collectionDao.selectByUser(uid,type);
            logger.info("music"+musics.toString());
        }catch (Exception e){
            logger.error("[CollectionServiceImpl][selectMusicByUser]:uid="+uid+"mid="+mid+e.getLocalizedMessage() + ":" + e.getMessage(),e.getCause());
        }
        return musics;
    }

    public boolean checkCollectionExist(Long mid, Integer uid, int type) {
        int result = 0;
        try{
            result = collectionDao.selecCollectionCountByUidAndMid(mid,uid,type);
        }catch (Exception e){
            logger.error("[CollectionServiceImpl][checkCollectionExist]"+e.getLocalizedMessage() + ":" + e.getMessage(),e.getCause());
        }
        return result>0 ?true:false;
    }

    public boolean insertCollection(CollectionMusic collectionMusic) {
        int result = 0;
        try{
            result = collectionDao.insertCollection(collectionMusic);
        }catch (Exception e){
            logger.error("[CollectionServiceImpl][insertCollection]"+e.getLocalizedMessage() + ":" + e.getMessage(),e.getCause());
        }
        return result>0 ?true:false;
    }

    public boolean deleteCollection(Long mid,Integer uid, int type) {
        int result = 0;
        try{
            result = collectionDao.deleteCollection(mid,uid,type);
        }catch (Exception e){
            logger.error("[CollectionServiceImpl][deleteCollection]"+e.getLocalizedMessage() + ":" + e.getMessage(),e.getCause());
        }
        return result>0 ?true:false;
    }
}