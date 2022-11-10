package com.pms.pms.service;

import com.pms.pms.Dto.AppointmentDto;
import com.pms.pms.Entity.Appointment;
import com.pms.pms.Entity.User;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {
  Appointment createAppointment(AppointmentDto appointmentDto);

  List<Appointment> getAllAppointment();

  Appointment getAppointmentByUser(Long userId);


  Appointment updateAppointment(Appointment appointment, Long id);

  void deleteAppointment(Long id);


}
