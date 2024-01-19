package com.example.blogApp.post;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Post {
    
    @Id
    @GeneratedValue
    private Long postid;
    private String post_title;
    private String content;
    private LocalDate date_posted;
    private Long authorid;
    
    
    public Post() {
    }
    public Long getPostid() {
        return postid;
    }
    public void setPostid(Long postid) {
        this.postid = postid;
    }
    public String getPost_title() {
        return post_title;
    }
    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public LocalDate getDate_posted() {
        return date_posted;
    }
    public void setDate_posted(LocalDate date_posted) {
        this.date_posted = date_posted;
    }
    public Long getAuthorid() {
        return authorid;
    }
    public void setAuthorid(Long authorid) {
        this.authorid = authorid;
    }
}
