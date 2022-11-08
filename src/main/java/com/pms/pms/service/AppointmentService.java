package com.pms.pms.service;

import com.pms.pms.Dto.AppointmentDto;
import com.pms.pms.Entity.Appointment;

public interface AppointmentService {
  Appointment createAppointment(Appointment appointment);

  void updateAppointment(Appointment appointment);


}
