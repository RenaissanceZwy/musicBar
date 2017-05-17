package com.music.web.dao;

import com.music.web.entity.Posting;
import com.music.web.vo.PostingVo;
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
}