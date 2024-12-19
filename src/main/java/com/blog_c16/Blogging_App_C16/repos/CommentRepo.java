package com.blog_c16.Blogging_App_C16.repos;

import com.blog_c16.Blogging_App_C16.entities.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepo extends CrudRepository<Comment, Long> {

    Comment findByIdAndPostId(Long id, Long postId);

    List<Comment> findByPostId(Long postId);

    List<Comment> findAll();




}
