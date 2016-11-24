package com.music.web.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016/11/16.
 */
public class CollectionMusic implements Serializable{

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long uid;
    private Long mid;
    private Date time;
    private int type;

    public CollectionMusic() {
    }

    public CollectionMusic( Long uid, Long mid, Date time, int type) {
        this.uid = uid;
        this.mid = mid;
        this.time = time;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "CollectionMusic{" +
                "id=" + id +
                ", uid=" + uid +
                ", mid=" + mid +
                ", time=" + time +
                ", type=" + type +
                '}';
    }
}
