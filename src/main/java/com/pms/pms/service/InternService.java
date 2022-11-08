package com.pms.pms.service;

import com.pms.pms.Dto.CommentDto;
import com.pms.pms.Entity.Appointment;
import com.pms.pms.Entity.Comment;
import com.pms.pms.Entity.Intern;

import java.util.List;
import java.util.Optional;

public interface InternService {


    Intern createIntern(Intern intern);

    void createCommentToProject(CommentDto commentDto, Long id, Long projectId);

    Appointment checkAppointmentStatus();



    List<Comment> viewAllComment();

    List<Intern> getAllIntern();
    Optional<Intern> getInternById(Long id);

    Intern updateIntern(Intern intern, Long id);

    void deleteIntern(Long id);

}
