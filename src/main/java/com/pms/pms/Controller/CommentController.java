package com.pms.pms.Controller;

import com.pms.pms.Entity.Comment;
import com.pms.pms.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api2")
public class CommentController {
    @Autowired
    CommentService commentService;
    @PostMapping("")
    @ResponseBody

    //build add comment api
    public ResponseEntity<Comment> AddComment(@RequestBody Comment comment){


        Comment newComment = commentService.addComment(comment);
        return new ResponseEntity<>(newComment, HttpStatus.CREATED);

    }



    //build view all comment api

    @GetMapping("/comment")
    @ResponseBody
    public List<Comment> viewAllComment(){
        return commentService.viewAllComment();
    }


    //build get all comment by id
    @GetMapping("/comment/{id}")
    public ResponseEntity<Comment> viewCommentById(@PathVariable("id") Long id){
        Optional<Comment> comment = commentService.viewCommentById(id);
        return new ResponseEntity<Comment>(comment.get(),HttpStatus.OK);
    }

    // build update comment api
    @PutMapping("/comment/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable("id") Long id , Comment comment){
        Comment commentResponse =  commentService.updateComment(comment, id);
        return  new ResponseEntity<>(commentResponse, HttpStatus.OK);
    }
    //build delete comment api
    @DeleteMapping("/comment/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable("id") Long id, Comment comment){
        commentService.deleteComment(id);
        return new ResponseEntity<String>("Comment deleted successfully", HttpStatus.OK);
    }

}
