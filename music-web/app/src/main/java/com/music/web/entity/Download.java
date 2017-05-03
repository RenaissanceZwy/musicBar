package com.music.web.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016/11/16.
 */
public class Download implements Serializable{

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long uid;
    private Long mid;
    private Date time;

    public Download(Long uid, Long mid, Date time) {
        this.uid = uid;
        this.mid = mid;
        this.time = time;
    }

    public Download() {
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

    @Override
    public String toString() {
        return "Download{" +
                "id=" + id +
                ", uid=" + uid +
                ", mid=" + mid +
                ", time=" + time +
                '}';
    }
}