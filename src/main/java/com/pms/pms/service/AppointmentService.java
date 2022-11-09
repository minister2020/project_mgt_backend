package com.pms.pms.service;

import com.pms.pms.Dto.AppointmentDto;
import com.pms.pms.Entity.Appointment;
import com.pms.pms.Entity.User;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {
  Appointment createAppointment(Appointment appointment);

  List<Appointment> getAllAppointment();

  Optional<Appointment> getAppointmentById(Long id);


  Appointment updateAppointment(Appointment appointment, Long id);

  void deleteAppointment(Long id);


}
