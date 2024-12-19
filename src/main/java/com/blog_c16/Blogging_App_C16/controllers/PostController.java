package com.blog_c16.Blogging_App_C16.controllers;


import com.blog_c16.Blogging_App_C16.entities.Post;
import com.blog_c16.Blogging_App_C16.service.PostService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostService postService;

    private final Logger logger = LoggerFactory.getLogger(PostController.class);

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getPosts(){

        return ResponseEntity.ok(postService.getAllPosts());
    }


    @PostMapping("/posts")
    public ResponseEntity<Void> createPost(@Valid @RequestBody Post post){
        postService.addPost(post);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{postId}")
                .buildAndExpand(post.getId())
                .toUri();
        responseHeaders.setLocation(location);
        logger.info("Created post successfully [id: " + post.getId() + "].");
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<?> getPost(@PathVariable Long postId){
        Post post = postService.getPostById(postId);
        logger.info("Responded successfully with post [id: " + postId + "].");
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PutMapping("/posts/{postId}")
    public ResponseEntity<?> updatePost(@PathVariable Long postId, @RequestBody Post post) {
        logger.info("Updated post successfully [id: " + postId + "].");
        postService.editPost(postId, post);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/post")
    public ResponseEntity<?> getPostByTitle(@RequestParam String title) {
        Post post = postService.getPostByTitle(title);
        logger.info("Responded successfully with post entitled " + title + ".");
        return new ResponseEntity<>(post, HttpStatus.OK);
    }


    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Long postId) {
        postService.deletePostById(postId);
        logger.info("Successfully deleted post.");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //Update a Post~
    //Get a single post~
    //getPostByTitle using Query Parameters =  @RequestParam~
    //delete a post~


}
