package com.pms.pms.Controller;

import com.pms.pms.Dto.CommentDto;
import com.pms.pms.Entity.Comment;
import com.pms.pms.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping("/addComment")
    @ResponseBody

    //build add comment api
    public ResponseEntity<Comment> AddComment(@RequestBody CommentDto commentDto) {

        Comment newComment = commentService.addComment(commentDto);
        return new ResponseEntity<>(newComment, HttpStatus.CREATED);

    }

    //build get all comment by id
    @GetMapping("/comment/{id}")
    public ResponseEntity<Comment> viewCommentsByProject(@PathVariable("id") Long id) {
        Optional<Comment> comment = commentService.viewCommentsByProject(id);
        return new ResponseEntity<Comment>(comment.get(), HttpStatus.OK);
    }


    //build delete comment api
    @DeleteMapping("/comment/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable("id") Long id, Comment comment){
        commentService.deleteComment(id);
        return new ResponseEntity<String>("Comment deleted successfully", HttpStatus.OK);
    }

}
