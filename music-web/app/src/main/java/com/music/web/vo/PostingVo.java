package com.music.web.vo;

import java.util.Date;

/**
 * 帖子的详细信息
 * Created by Administrator on 2017/5/1.
 */
public class PostingVo {

    private Integer id;

    private Integer uid;

    private String title;

    private String content;

    private String label;

    private Date createtime;

    private int status;

    //用户名
    private String username;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "PostingVo{" +
                "id=" + id +
                ", uid=" + uid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", label='" + label + '\'' +
                ", createtime=" + createtime +
                ", status=" + status +
                ", username='" + username + '\'' +
                '}';
    }
}
