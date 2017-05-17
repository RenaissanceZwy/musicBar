package com.music.web.dao;

import com.music.web.entity.Comment;
import com.music.web.vo.CommentInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2016/11/16.
 */
@Repository
public interface CommentDao {

    /*通过歌曲id获取歌曲的评论信息*/
    public List<CommentInfo> selectCommentBySongId(@Param("id") String id,@Param("type") int type);

    public List<CommentInfo> selectCommentByUid(@Param("uid") Long uid);

    public List<CommentInfo> selectComments();

    public List<CommentInfo> selectCommentsByPage(@Param("offset") int offset,@Param("pageSize") int pageSize,
                                            @Param("name") String name);

    /*  通过评论id 选择评论*/
    public CommentInfo selectCommentById(@Param("id") Long id);

    /*插入评论操做*/
    public int insertComment(@Param("comment")Comment comment);

    /*删除评论操作*/
    public int deleteComment(@Param("id") Long id);

    //修改评论赞的次数
    public int updateCommentLike(@Param("id") Long id,@Param("like") int like);


}
