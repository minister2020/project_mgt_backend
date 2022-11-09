package com.pms.pms.service.serviceImpl;

import com.pms.pms.Dto.CommentDto;
import com.pms.pms.Entity.Comment;

import com.pms.pms.Exception.ResourceNotFoundException;
import com.pms.pms.Repository.CommentRepository;
import com.pms.pms.service.CommentService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    private final CommentRepository commentRepository;

    public Comment addComment(Comment comment) {
       Comment comment1 = new Comment();
       comment1.setId(comment.getId());
       comment1.setTitle(comment.getTitle());
       comment1.setMessage(comment.getMessage());

       return commentRepository.save(comment);
    }


    public List<Comment> viewAllComment() {
// TODO Auto-generated method stub
        return commentRepository.findAll();
    }

    @Override
    public Optional<Comment> viewCommentById(Long id) {

        Optional<Comment> comment = Optional.ofNullable(commentRepository.findById(id).get());
        if (comment.isPresent()) {
            return Optional.of(comment.get());
        } else {
            throw new ResourceNotFoundException("Comment", "id", id);
        }
    }

    @Override
    public Comment updateComment(Comment comment, Long id) {

        Comment existingComment = commentRepository.findById(id).get();
        existingComment.setTitle(comment.getTitle());
        existingComment.setMessage(comment.getMessage());

        return commentRepository.save(comment);

    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
