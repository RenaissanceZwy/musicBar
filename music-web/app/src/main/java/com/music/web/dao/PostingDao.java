package com.music.web.dao;

import com.music.web.entity.Posting;
import com.music.web.vo.PostingVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostingDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Posting record);

    int insertSelective(Posting record);

    Posting selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Posting record);

    int updateByPrimaryKey(Posting record);

    PostingVo selectPostingById(int id);

    List<PostingVo> selectPostings();

    List<PostingVo> selectPostingsByPage(@Param("offset") int offset, @Param("pageSize") int pageSize,
                                         @Param("name") String name);
}