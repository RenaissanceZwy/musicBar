package com.music.web.entity;

/**
 * Created by Administrator on 2017/5/21.
 */
public class PlayNum {

    private Integer uid ;

    private Integer mid;

    private Integer id;

    private Integer num;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "PlayNum{" +
                "uid=" + uid +
                ", mid=" + mid +
                ", id=" + id +
                ", num=" + num +
                '}';
    }
}
