package com.pms.pms.service;

import com.pms.pms.Entity.Comment;


import java.util.List;
import java.util.Optional;

public interface CommentService {
    Comment addComment(Comment comment);


    List<Comment> viewAllComment();

    Optional<Comment> viewCommentById(Long id);

    Comment updateComment(Comment comment, Long id);

    void deleteComment(Long id);
}
