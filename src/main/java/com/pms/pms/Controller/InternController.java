package com.pms.pms.Controller;


import com.pms.pms.Entity.Comment;
import com.pms.pms.Entity.Intern;
import com.pms.pms.Entity.Project;
import com.pms.pms.Repository.CommentRepository;
import com.pms.pms.Repository.InternRepository;
import com.pms.pms.Repository.ProjectRepository;
import com.pms.pms.service.CommentService;
import com.pms.pms.service.InternService;
import com.pms.pms.service.projectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class InternController {
    @Autowired
    InternService internService;
    CommentService commentService;
    CommentRepository commentRepository;
    @PostMapping("")
    @ResponseBody
    public ResponseEntity<Intern> createIntern(@RequestBody Intern intern){

        // create intern api
        Intern newIntern = internService.createIntern(intern);
        return new ResponseEntity<>(newIntern, HttpStatus.CREATED);

    }
     //build commentToProject api




    //build get all intern api

    @GetMapping("/intern")
    @ResponseBody
    public List<Intern> getAllIntern(){
        return internService.getAllIntern();
    }
    @GetMapping("/viewComment/")
    public List<Comment> viewAllComment(){
        return commentService.viewAllComment();
    }


    //build get all intern by id
    @GetMapping("/intern/{id}")
    public ResponseEntity<Intern> getInternById(@PathVariable("id") Long id){
        Optional<Intern> intern = internService.getInternById(id);
        return new ResponseEntity<Intern>(intern.get(),HttpStatus.OK);
    }

    // build update intern api
    @PutMapping("/intern/{id}")
    public ResponseEntity<Intern> updateIntern(@PathVariable("id") Long id , Intern intern){
        Intern internResponse =  internService.updateIntern(intern, id);
        return  new ResponseEntity<>(internResponse, HttpStatus.OK);
    }
     //build delete intern api
    @DeleteMapping("/intern/{id}")
    public ResponseEntity<String> deleteIntern(@PathVariable("id") Long id, Intern intern){
        internService.deleteIntern(id);
        return new ResponseEntity<String>("Intern deleted successfully", HttpStatus.OK);
    }



}
