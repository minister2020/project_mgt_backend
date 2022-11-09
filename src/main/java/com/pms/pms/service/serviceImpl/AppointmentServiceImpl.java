package com.pms.pms.service.serviceImpl;
import com.pms.pms.Entity.Appointment;
import com.pms.pms.Entity.User;
import com.pms.pms.Exception.ResourceNotFoundException;
import com.pms.pms.Repository.AppointmentRepository;
import com.pms.pms.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }
@Override
    public Appointment createAppointment(Appointment appointment){
        Appointment appointment1 = new Appointment();
        appointment1.setStartTime(appointment.getStartTime());
        appointment1.setEndTime(appointment.getEndTime());
        return appointmentRepository.save(appointment);
    }


   @Override
    public List<Appointment> getAllAppointment() {
// TODO Auto-generated method stub
        return appointmentRepository.findAll();
    }

  @Override
    public Optional<Appointment> getAppointmentById(Long id) {

        Optional<Appointment> appointment = Optional.ofNullable(appointmentRepository.findById(id).get());
        if (appointment.isPresent()) {
            return Optional.of(appointment.get());
        } else {
            throw new ResourceNotFoundException("User", "id", id);
        }
    }

@Override
    public Appointment updateAppointment(Appointment appointment, Long id){

    Appointment existingAppointment = appointmentRepository.findById(id).get();
    existingAppointment.setStartTime(appointment.getStartTime());
    existingAppointment.setEndTime(appointment.getEndTime());

    return appointmentRepository.save(appointment);

    }
    @Override
    public void deleteAppointment(Long id){
       appointmentRepository.deleteById(id);
    }
}
