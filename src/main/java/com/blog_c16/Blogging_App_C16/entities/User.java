package com.blog_c16.Blogging_App_C16.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    private String userName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private Set<Post> posts;

    public User() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

}
