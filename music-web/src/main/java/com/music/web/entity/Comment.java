package com.music.web.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016/11/16.
 */
public class Comment implements Serializable{
    private static final long serialVersionUID = 1L;

    private Long id;

    private Long uid;

    private Long mid;

    private Long fid;

    private Long fuid;

    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date time;

    private int likeNum;

    private int type;

    public Comment() {
    }


    public Comment(Long uid, Long mid, Long fid, Long fuid, String content, Date time, int likeNum) {
        this.uid = uid;
        this.mid = mid;
        this.fid = fid;
        this.fuid = fuid;
        this.content = content;
        this.time = time;
        this.likeNum = likeNum;
    }

    public Comment(Long uid, Long mid, Long fid, Long fuid, String content, Date time, int likeNum, int type) {
        this.uid = uid;
        this.mid = mid;
        this.fid = fid;
        this.fuid = fuid;
        this.content = content;
        this.time = time;
        this.likeNum = likeNum;
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public Long getFuid() {
        return fuid;
    }

    public void setFuid(Long fuid) {
        this.fuid = fuid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", uid=" + uid +
                ", mid=" + mid +
                ", fid=" + fid +
                ", fuid=" + fuid +
                ", content='" + content + '\'' +
                ", time=" + time +
                ", likeNum=" + likeNum +
                ", type=" + type +
                '}';
    }
}
