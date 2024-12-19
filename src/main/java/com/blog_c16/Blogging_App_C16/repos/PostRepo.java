package com.blog_c16.Blogging_App_C16.repos;

import com.blog_c16.Blogging_App_C16.entities.Comment;
import com.blog_c16.Blogging_App_C16.entities.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepo extends CrudRepository<Post, Long> {


    //Optional<Comment> findByIdAndPostId(Long id, Long postId);

}
