package com.pms.pms.Controller;


import com.pms.pms.Entity.Intern;
import com.pms.pms.Repository.InternRepository;
import com.pms.pms.service.InternService;
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
    @PostMapping("")
    @ResponseBody
    public ResponseEntity<Intern> createIntern(@RequestBody Intern intern){

        // create user api
        Intern newIntern = internService.createIntern(intern);
        return new ResponseEntity<>(newIntern, HttpStatus.CREATED);

    }



    //build get all user api

    @GetMapping("/intern")
    @ResponseBody
    public List<Intern> getAllIntern(){
        return internService.getAllIntern();
    }


    //build get all user by id
    @GetMapping("/intern/{id}")
    public ResponseEntity<Intern> getInternById(@PathVariable("id") Long id){
        Optional<Intern> intern = internService.getInternById(id);
        return new ResponseEntity<Intern>(intern.get(),HttpStatus.OK);
    }

    // build update user api
    @PutMapping("/intern/{id}")
    public ResponseEntity<Intern> updateIntern(@PathVariable("id") Long id , Intern intern){
        Intern internResponse =  internService.updateIntern(intern, id);
        return  new ResponseEntity<>(internResponse, HttpStatus.OK);
    }

    @DeleteMapping("/intern/{id}")
    public ResponseEntity<String> deleteIntern(@PathVariable("id") Long id, Intern intern){
        internService.deleteIntern(id);
        return new ResponseEntity<String>("Intern deleted successfully", HttpStatus.OK);
    }



}
