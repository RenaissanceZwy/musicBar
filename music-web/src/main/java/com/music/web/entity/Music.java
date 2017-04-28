package com.music.web.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/11/16.
 */
public class Music implements Serializable{
    private static final long serialVersionUID = 1L;

    private Long id;
    private String musicName;
    private String singer;
    private String albumName;
    private String songId;
    private String picUrl;
    private int    playNum;
    private String length;
    private String language;
    private String describes;
    private int    singerid;


    public Music(String musicName, String singer, String albumName, String songId, String picUrl, int playNum) {
        this.musicName = musicName;
        this.singer = singer;
        this.albumName = albumName;
        this.songId = songId;
        this.picUrl = picUrl;
        this.playNum = playNum;
    }

    public Music() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public int getPlayNum() {
        return playNum;
    }

    public void setPlayNum(int playNum) {
        this.playNum = playNum;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public int getSingerid() {
        return singerid;
    }

    public void setSingerid(int singerid) {
        this.singerid = singerid;
    }

    @Override
    public String toString() {
        return "Music{" +
                "id=" + id +
                ", musicName='" + musicName + '\'' +
                ", singer='" + singer + '\'' +
                ", albumName='" + albumName + '\'' +
                ", songId='" + songId + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", playNum=" + playNum +
                ", length='" + length + '\'' +
                ", language='" + language + '\'' +
                ", describes='" + describes + '\'' +
                ", singerid=" + singerid +
                '}';
    }
}
