package com.technews.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

    @Entity
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @Table(name = "post")
    public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String postUrl;
    @Transient
    private String userName;
    @Transient
    private int voteCount;
    private Integer userId;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "posted-at")
    private Date postedAt = new Date();

    @Temporal(TemporalType.DATE)
    @Column(name = "posted-at")
    private Date updatedAt = new Date();

//    Need to use FetchType.LAZY to resolve multiple bags exception
    @OneToMany(mappedBy = "postId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> comments;
    public Post() {
    }

    public Post(Integer id, String title, String postUrl, int voteCount, Integer userId) {
    this.id = id;
    this.title = title;
    this.postUrl = postUrl;
    this.voteCount = voteCount;
    this.userId = userId;
    }

    public Integer getId() {
    return id;
    }

    public void setId(Integer id) {
    this.id = id;
    }

    public String getTitle() {
    return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPostUrl() {
        return postUrl;
    }
    public void setPostUrl(String postUrl) {
        this.postUrl = postUrl;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }



}
