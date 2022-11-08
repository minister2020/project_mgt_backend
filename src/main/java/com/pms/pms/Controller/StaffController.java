package com.pms.pms.Controller;

import com.pms.pms.Entity.Comment;
import com.pms.pms.Entity.Staff;
import com.pms.pms.service.CommentService;
import com.pms.pms.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api1")
public class StaffController {

    @Autowired
    private final StaffService staffService;
    private final CommentService commentService;

    public StaffController(StaffService staffService, CommentService commentService) {
        this.staffService = staffService;
        this.commentService = commentService;
    }

    @PostMapping("")
    @ResponseBody
    public ResponseEntity<Staff> createStaff(@RequestBody Staff staff){

        // create staff api
        Staff newStaff = staffService.createStaff(staff);
        return new ResponseEntity<>(newStaff, HttpStatus.CREATED);

    }

    //build commentToproject api

    @GetMapping("/comment")
    @ResponseBody
    public ResponseEntity<Comment> createCommentToProject(@RequestBody Comment comment) {

        // create intern api
        Comment newComment = commentService.addComment(comment);
        return new ResponseEntity<>(newComment, HttpStatus.CREATED);
    }



    //build get all staff api

    @GetMapping("/staff")
    @ResponseBody
    public List<Staff> getAllStaff(){
        return staffService.getAllStaff();
    }


    //build get all staff by id
    @GetMapping("/staff/{id}")
    public ResponseEntity<Staff> getStaffById(@PathVariable("id") Long id){
        Optional<Staff> staff = staffService.getStaffById(id);
        return new ResponseEntity<Staff>(staff.get(),HttpStatus.OK);
    }

    // build update staff api
    @PutMapping("/staff/{id}")
    public ResponseEntity<Staff> updateIntern(@PathVariable("id") Long id , Staff staff){
        Staff staffResponse =  staffService.updateStaff(staff, id);
        return  new ResponseEntity<>(staffResponse, HttpStatus.OK);
    }
  //build delete staff api
    @DeleteMapping("/staff/{id}")
    public ResponseEntity<String> deleteStaff(@PathVariable("id") Long id, Staff staff){
        staffService.deleteStaff(id);
        return new ResponseEntity<String>("Staff deleted successfully", HttpStatus.OK);
    }
}
