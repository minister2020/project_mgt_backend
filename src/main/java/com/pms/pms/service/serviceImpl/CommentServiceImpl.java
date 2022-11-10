package com.pms.pms.service.serviceImpl;

import com.pms.pms.Dto.CommentDto;
import com.pms.pms.Entity.Comment;

import com.pms.pms.Entity.Project;
import com.pms.pms.Entity.User;
import com.pms.pms.Exception.ResourceNotFoundException;
import com.pms.pms.Repository.CommentRepository;
import com.pms.pms.Repository.ProjectRepository;
import com.pms.pms.Repository.UserRepository;
import com.pms.pms.service.CommentService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class CommentServiceImpl implements CommentService {


    private final CommentRepository commentRepository;
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    public CommentServiceImpl(CommentRepository commentRepository, ProjectRepository projectRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;

    }

    public Comment addComment(CommentDto commentDto) {
       Project  project = projectRepository.findById(commentDto.getProjectId()).get();
       User user = userRepository.findById(commentDto.getUserId()).get();
       Comment comment = new Comment();
       comment.setTitle(commentDto.getTitle());
       comment.setMessage(commentDto.getMessage());
       comment.setProject(project);
       comment.setUser(user);
       return commentRepository.save(comment);
    }


    public List<Comment> viewAllComment() {
// TODO Auto-generated method stub
        return commentRepository.findAll();
    }

    @Override
    public Optional<Comment> viewCommentsByProject(Long id) {

        Optional<Comment> comment = Optional.ofNullable(commentRepository.findById(id).get());
        if (comment.isPresent()) {
            return Optional.of(comment.get());
        } else {
            throw new ResourceNotFoundException("Comment", "id", id);
        }
    }

//    @Override
//    public Comment updateComment(Comment comment, Long id) {
//
//        Comment existingComment = commentRepository.findById(id).get();
//        existingComment.setTitle(comment.getTitle());
//        existingComment.setMessage(comment.getMessage());
//
//        return commentRepository.save(comment);
//
//    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
