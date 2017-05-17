package com.music.web.dao;

import com.music.web.entity.Label;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabelDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Label record);

    int insertSelective(Label record);

    Label selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Label record);

    int updateByPrimaryKey(Label record);

    Label selectLabelByType(@Param("filter") String filter,@Param("type") int type);

    List<Label> selectLabels();

    List<Label> selectLabelsByPage(@Param("offset") int offset,@Param("pageSize") int pageSize
            ,@Param("name") String name);
}