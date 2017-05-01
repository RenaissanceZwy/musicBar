package com.music.web.dao;

import com.music.web.entity.Follow;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Follow record);

    int insertSelective(Follow record);

    Follow selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Follow record);

    int updateByPrimaryKey(Follow record);

    int deleteFollow(Follow follow);

    Follow selectFollow(Follow follow);
}