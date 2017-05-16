package com.music.web.service;

import com.music.web.entity.Label;

import java.util.List;

/**
 * 标签相关
 * Created by Administrator on 2017/4/29.
 */
public interface LabelService {
    //新建一个标签
    boolean insertLabel(Label label);
    //删除一个标签
    boolean deletLabelById(int id);
    //获取一个标签 0-id 1-name
    Label selectLabel(String filter,int type);
    //获取所有的标签
    List<Label> selectLabels();
}
