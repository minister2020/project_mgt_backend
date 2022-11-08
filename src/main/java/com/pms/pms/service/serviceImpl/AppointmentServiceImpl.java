package com.pms.pms.service.serviceImpl;

import com.pms.pms.Dto.AppointmentDto;
import com.pms.pms.Entity.Appointment;
import com.pms.pms.Repository.AppointmentRepository;
import com.pms.pms.Repository.ProjectRepository;
import com.pms.pms.service.AppointmentService;
import com.pms.pms.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Embedded;

@Service

public class AppointmentServiceImpl implements AppointmentService {
    @Embedded
    @Autowired
    AppointmentRepository appointmentDto;
    CommentService commentService;
    ProjectRepository projectService;


    public Appointment createAppointment(Appointment appointment){


        Appointment appointment1 = new Appointment();
        appointment1.setId(appointment.getId());
        appointment1.setStart(appointment.getStart());
        appointment1.setEndApp(appointment.getEndApp());
        appointment1.setCanceledAt(appointment.getCanceledAt());

       return appointmentDto.save(appointment);
    }


    @Override
    public void updateAppointment(Appointment appointment) {
    Appointment existingAppointment = appointmentDto.findById(appointment.getId()).get();
    existingAppointment.setId(appointment.getId());
    existingAppointment.setStart(appointment.getStart());
    existingAppointment.setEndApp(appointment.getEndApp());
    existingAppointment.setCanceledAt(appointment.getCanceledAt());


    }
}
