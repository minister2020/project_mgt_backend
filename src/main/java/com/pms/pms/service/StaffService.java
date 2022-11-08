package com.pms.pms.service;

import com.pms.pms.Dto.AppointmentDto;
import com.pms.pms.Dto.CommentDto;
import com.pms.pms.Entity.Comment;
import com.pms.pms.Entity.Intern;
import com.pms.pms.Entity.Staff;

import java.util.List;
import java.util.Optional;

public interface StaffService {
    Staff createStaff(Staff staff);

    void createCommentToProject(CommentDto commentDto, Long Id, Long projectId);

    void updateAppointmentStatus(Long appointmentId, AppointmentDto appointmentDto);
    List<Staff> getAllStaff();
    Optional<Staff> getStaffById(Long id);

    Staff updateStaff(Staff staff, Long id);

    void deleteStaff(Long id);

}
