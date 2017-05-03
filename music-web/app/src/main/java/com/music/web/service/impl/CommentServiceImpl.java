package com.music.web.service.impl;

import com.music.web.dao.CommentDao;
import com.music.web.entity.Comment;
import com.music.web.service.CommentService;
import com.music.web.vo.CommentInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/11/16.
 */
@Service(value = "CommentService")
public class CommentServiceImpl implements CommentService {

    private static  final Logger logger = LoggerFactory.getLogger(CommentServiceImpl.class);

    @Autowired
    private CommentDao commentDao;

    public List<CommentInfo> getComment(String id,int type) {
        List<CommentInfo> commentInfos = null;
        try{
            commentInfos = commentDao.selectCommentBySongId(id,type);
        }catch (Exception e){
            logger.error("[CommentServiceImpl][getComment]"+e.getLocalizedMessage() + ":" + e);
        }
        return commentInfos;
    }

    public List<CommentInfo> getCommentByUid(Long uid) {
        List<CommentInfo> commentInfos = null;
        try{
            commentInfos = commentDao.selectCommentByUid(uid);
        }catch (Exception e){
            logger.error("[CommentServiceImpl][getCommentByUid]"+e.getLocalizedMessage() + ":" + e.getMessage(),e.getCause());
        }
        return commentInfos;
    }

    public List<CommentInfo> getComments() {
        List<CommentInfo> commentInfos = null;
        try{
            commentInfos = commentDao.selectComments();
        }catch (Exception e){
            logger.error("[CommentServiceImpl][getComments]"+e.getLocalizedMessage() + ":" + e.getMessage(),e.getCause());
        }
        return commentInfos;
    }

    public CommentInfo getCommentById(Long id) {
       CommentInfo commentInfo = null;
        try{
            commentInfo = commentDao.selectCommentById(id);
        }catch (Exception e){
            logger.error("[CommentServiceImpl][getCommentById]"+e.getLocalizedMessage() + ":" + e.getMessage(),e.getCause());
        }
        return commentInfo;
    }

    public boolean insertComment(Comment comment) {
        int result = 0;
        try{
            result = commentDao.insertComment(comment);
        }catch (Exception e){
            logger.error("[CommentServiceImpl][insertComment]"+e.getLocalizedMessage() + ":" + e.getMessage(),e.getCause());
        }
        return result>0 ?true:false;
    }

    public boolean deleteComment(Long id) {
        int result = 0;
        try{
            result = commentDao.deleteComment(id);
        }catch (Exception e){
            logger.error("[CommentServiceImpl][deleteComment]"+e.getLocalizedMessage() + ":" + e.getMessage(),e.getCause());
        }
        return result>0 ?true:false;
    }

    public boolean modifyCommentLike(Long id, int like) {
        int result = 0;
        try{
            result = commentDao.updateCommentLike(id,like);
        }catch (Exception e){
            logger.error("[CommentServiceImpl][modifyCommentLike]"+e.getLocalizedMessage() + ":" + e.getMessage(),e.getCause());
        }
        return result>0 ?true:false;
    }
}
