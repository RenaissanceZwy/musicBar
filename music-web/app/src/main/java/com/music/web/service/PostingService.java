package com.music.web.service;

import com.music.web.entity.Posting;
import com.music.web.vo.PostingVo;

/**
 * 帖子相关
 * Created by Administrator on 2017/4/29.
 */
public interface PostingService {
    //新建帖子
    boolean insertPosting(Posting posting);

    //删除帖子
    boolean deletePosting(int id);

    //获取帖子
    PostingVo selectPosting(int id);
}
