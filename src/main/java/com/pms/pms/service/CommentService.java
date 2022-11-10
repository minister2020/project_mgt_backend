package com.pms.pms.service;

import com.pms.pms.Dto.CommentDto;
import com.pms.pms.Entity.Comment;


import java.util.List;
import java.util.Optional;

public interface CommentService {
    Comment addComment(CommentDto commentDto);

    Optional<Comment> viewCommentsByProject(Long projectId);

    void deleteComment(Long id);
}
