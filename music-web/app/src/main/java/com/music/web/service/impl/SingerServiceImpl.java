package com.music.web.service.impl;

import com.music.web.dao.SingerDao;
import com.music.web.entity.Singer;
import com.music.web.service.SingerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/4/29.
 */
@Service(value = "SingerService")
public class SingerServiceImpl implements SingerService {

    private static  final Logger logger = LoggerFactory.getLogger(SingerServiceImpl.class);

    @Autowired
    private SingerDao singerDao;

    public boolean insertSinger(Singer singer) {
        int result = 0;
        try{
            result = singerDao.insert(singer);
        }catch (Exception e){
            logger.info("[SingerServiceImpl][insertSinger]singer:"+singer.toString()+e);
        }
        return result>0;
    }

    public Singer selectSinger(int id) {
        Singer result = null;
        try{
            result = singerDao.selectByPrimaryKey(id);
        }catch (Exception e){
            logger.info("[SingerServiceImpl][selectSinger] id:"+id+e);
        }
        return result;
    }

    public boolean deleteSinger(int id) {
        int result = 0;
        try{
            result = singerDao.deleteByPrimaryKey(id);
        }catch (Exception e){
            logger.info("[SingerServiceImpl][deleteSinger] id:"+id+e);
        }
        return result>0;
    }
}
