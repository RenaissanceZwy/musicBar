package com.music.web.vo;

import java.util.Date;

/**
 * Created by Administrator on 2016/11/18.
 */
public class CommentInfo {

    private Long id;

    private Long uid;

    private Long mid;

    private Long fid;

    private Long fuid;

    private String content;

    private Date time;

    private int likeNum;

    private String headImg;

    private  String username;

    public CommentInfo() {
    }

    public CommentInfo(Long uid, Long mid, Long fid, Long fuid, String content, Date time, int likeNum, String headImg, String username) {
        this.uid = uid;
        this.mid = mid;
        this.fid = fid;
        this.fuid = fuid;
        this.content = content;
        this.time = time;
        this.likeNum = likeNum;
        this.headImg = headImg;
        this.username = username;
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }


    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "CommentInfo{" +
                "id=" + id +
                ", uid=" + uid +
                ", mid=" + mid +
                ", fid=" + fid +
                ", fuid=" + fuid +
                ", content='" + content + '\'' +
                ", time=" + time +
                ", likeNum=" + likeNum +
                ", headImg='" + headImg + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
