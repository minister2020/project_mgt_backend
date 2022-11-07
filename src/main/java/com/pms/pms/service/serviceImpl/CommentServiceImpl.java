package com.pms.pms.service.serviceImpl;

import com.pms.pms.Dto.CommentDto;
import com.pms.pms.Entity.Comment;
import com.pms.pms.Entity.Staff;
import com.pms.pms.Exception.ResourceNotFoundException;
import com.pms.pms.Repository.CommentRepository;
import com.pms.pms.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Embedded;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    @Embedded
    @Autowired

    CommentRepository commentDto;

    public Comment addComment(Comment comment) {
       Comment comment1 = new Comment();
       comment1.setId(comment.getId());
       comment1.setTitle(comment.getTitle());
       comment1.setMessage(comment.getMessage());

       return commentDto.save(comment);
    }


    public List<Comment> viewAllComment() {
// TODO Auto-generated method stub
        return commentDto.findAll();
    }

    @Override
    public Optional<Comment> viewCommentById(Long id) {

        Optional<Comment> comment = Optional.ofNullable(commentDto.findById(id).get());
        if (comment.isPresent()) {
            return Optional.of(comment.get());
        } else {
            throw new ResourceNotFoundException("Comment", "id", id);
        }
    }

    @Override
    public Comment updateComment(Comment comment, Long id) {

        Comment existingComment = commentDto.findById(id).get();
        existingComment.setTitle(comment.getTitle());
        existingComment.setMessage(comment.getMessage());

        return commentDto.save(comment);

    }

    @Override
    public void deleteComment(Long id) {
        commentDto.deleteById(id);
    }
}
