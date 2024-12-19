package com.blog_c16.Blogging_App_C16.controllers;


import com.blog_c16.Blogging_App_C16.entities.Comment;
import com.blog_c16.Blogging_App_C16.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    CommentService commentService;


    @PostMapping("/comments/{postId}/comments")
    public void addCommentToPost(@PathVariable Long postId, @RequestBody Comment comment){
        commentService.addComment(postId, comment);
    }

    @DeleteMapping("/comments/{commentId}/posts/{postId}")
    public ResponseEntity<?> deleteComment(@PathVariable Long commentId, @PathVariable Long postId){
        commentService.deleteComment(commentId, postId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("comments/{postId}/comments")
    public ResponseEntity<List<Comment>> getAllCommentsByPost(@PathVariable Long postId) {
        return ResponseEntity.ok(commentService.getAllCommentsOnPost(postId));
    }

    @GetMapping("/comments")
    public ResponseEntity<List<Comment>> getAllComments(){
        return ResponseEntity.ok(commentService.getEveryComment());

    }

    @GetMapping("comments/{commentId}/posts/{postId}")
    public ResponseEntity<Comment> getComment(@PathVariable Long commentId, @PathVariable Long postId){
        return ResponseEntity.ok(commentService.getSingleComment(commentId, postId));
    }



    //Get All comments~
    //Get a comment - throw a ResourceNotFound exception~
    //Get all comments by post~
}
