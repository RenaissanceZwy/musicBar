package com.music.web.service.impl;

import com.music.web.dao.PostingDao;
import com.music.web.entity.Posting;
import com.music.web.service.PostingService;
import com.music.web.vo.PostingVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/4/29.
 */
@Service(value = "PostingService")
public class PostingServiceImpl implements PostingService {

    private static  final Logger logger = LoggerFactory.getLogger(PostingServiceImpl.class);

    @Autowired
    private PostingDao postingDao;

    public boolean insertPosting(Posting posting) {
        int result = 0;
        try{
            result = postingDao.insertSelective(posting);
        }catch (Exception e){
            logger.info("[PostingServiceImpl][insertPosting]posting:"+posting.toString()+e);
        }
        return result>0;
    }

    public boolean deletePosting(int id) {
        int result = 0;
        try{
            result = postingDao.deleteByPrimaryKey(id);
        }catch (Exception e){
            logger.info("[PostingServiceImpl][deletePosting]id:"+id+e);
        }
        return result>0;
    }

    public PostingVo selectPosting(int id) {
        PostingVo result = null;
        try{
            result = postingDao.selectPostingById(id);
        }catch (Exception e){
            logger.info("[PostingServiceImpl][selectPosting]id:"+id+e);
        }
        return result;
    }
}