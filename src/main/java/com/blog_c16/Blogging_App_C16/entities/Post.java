package com.blog_c16.Blogging_App_C16.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.annotations.NotFound;


//@Table(name = "post")
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotFound
    private Long id;

    @NotEmpty(message = "Post must have a title.")
    private String title;

    @NotEmpty(message = "Post must have content.")
    @Lob
    private String content;

    public Post(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


}
