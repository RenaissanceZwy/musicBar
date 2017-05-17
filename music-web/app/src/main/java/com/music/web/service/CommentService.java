package com.music.web.service;

import com.music.web.entity.Comment;
import com.music.web.vo.CommentInfo;

import java.util.List;

/**
 * Created by Administrator on 2016/11/16.
 */
public interface CommentService {

    /*通过歌曲id获取歌曲的评论信息*/
    public List<CommentInfo> getComment( String songId,int type);

    /*通过用户id获取歌曲的评论信息*/
    public List<CommentInfo> getCommentByUid(Long uid);

    /*获取所有的评论信息*/
    public List<CommentInfo> getComments();

    public List<CommentInfo> getComments(int pageNum,int PageSize,String name);

    /*  通过评论id 选择评论*/
    public CommentInfo getCommentById( Long id);

    /*插入评论操做*/
    public boolean insertComment(Comment comment);

    /*删除评论操作*/
    public boolean deleteComment( Long id);

    //修改评论赞的次数
    public boolean modifyCommentLike( Long id,int like);
}
