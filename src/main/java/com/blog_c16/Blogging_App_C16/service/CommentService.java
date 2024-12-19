package com.blog_c16.Blogging_App_C16.service;


import com.blog_c16.Blogging_App_C16.exception.ResourceNotFoundException;
import com.blog_c16.Blogging_App_C16.entities.Comment;
import com.blog_c16.Blogging_App_C16.entities.Post;
import com.blog_c16.Blogging_App_C16.repos.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {


    @Autowired
    CommentRepo commentRepo;

    @Autowired
    PostService postService;

    public void addComment(Long postId, Comment comment) {
        Post post = postService.getPostById(postId);
        comment.setPost(post);
        commentRepo.save(comment);

    }

    public void deleteComment(Long commentId, Long postId) {

        Comment comment = commentRepo.findByIdAndPostId(commentId, postId);
        commentRepo.delete(comment);
    }

    public List<Comment> getAllCommentsOnPost(Long postId) {
        List<Comment> allComments = new ArrayList<>();
        allComments.addAll(commentRepo.findByPostId(postId));
        //for (Comment comment : commentRepo.findByPostId(postId)) {
        //    allComments.add(comment);
        //}

        return allComments;
    }

    public List<Comment> getEveryComment() {
        return commentRepo.findAll();
    }

    public Comment getSingleComment(Long commentId, Long postId) throws ResourceNotFoundException {
        Comment comment = commentRepo.findByIdAndPostId(commentId, postId);
        if (comment.getId().equals(commentId)){
            return comment;
        }
        throw new ResourceNotFoundException("Comment not found.");
    }

}

    //Get All comments
    //Get a comment - throw a ResourceNotFound exception
    //Get all comments by post



