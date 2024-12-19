package com.blog_c16.Blogging_App_C16.service;


import com.blog_c16.Blogging_App_C16.exception.ResourceNotFoundException;
import com.blog_c16.Blogging_App_C16.entities.Post;
import com.blog_c16.Blogging_App_C16.repos.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepo postRepo;




    public List<Post> getAllPosts() {
        List<Post> allPosts = new ArrayList<>();

        for (Post post : postRepo.findAll()) {
            allPosts.add(post);
        }

        return allPosts;
    }

    public void addPost(Post post) {
        postRepo.save(post);
    }

    public Post getPostById(Long postId) {
        for (Post post : getAllPosts()) {
            if (post.getId().equals(postId)) {
                return post;
            }
        }
        throw new ResourceNotFoundException("Post with id of " + postId + " not found.");
    }

    public void editPost(Long postId, Post post) {
        Post p = getPostById(postId);
        if (p.getId().equals(postId)) {
            p.setTitle(post.getTitle());
            p.setContent(post.getContent());
            postRepo.save(p);
        }
    }


    public Post getPostByTitle(String postTitle){
        for (Post post : getAllPosts()) {
            if(post.getTitle().equalsIgnoreCase(postTitle)){
                return post;
            }
        }
        throw new ResourceNotFoundException("Post with title: " + postTitle + " not found");
    }


    public void deletePostById(Long postId){
    postRepo.deleteById(postId);

    }

}
