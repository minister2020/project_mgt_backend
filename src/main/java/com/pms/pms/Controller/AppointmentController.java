package com.pms.pms.Controller;

import com.pms.pms.Dto.AppointmentDto;
import com.pms.pms.Entity.Appointment;
import com.pms.pms.service.AppointmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api4")
@Slf4j
public class AppointmentController {
    @Autowired

    AppointmentService appointmentService;
    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<Appointment> createAppointment( @RequestBody AppointmentDto appointmentDto){
        log.info("appointment to be created, {}", appointmentDto);
        Appointment newAppointment = appointmentService.createAppointment(appointmentDto);
        return new ResponseEntity<>(newAppointment, HttpStatus.CREATED);
    }

    @DeleteMapping("/appointment/{id}")

    public ResponseEntity<String> deleteAppointment(@PathVariable("id") Long id, Appointment appointment){
        appointmentService.deleteAppointment(id);
        return new ResponseEntity<String>("Appointment has been terminated, pls kindly schedule again",
                HttpStatus.OK);
    }

}
