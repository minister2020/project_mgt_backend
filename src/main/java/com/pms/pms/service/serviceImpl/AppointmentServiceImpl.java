package com.pms.pms.service.serviceImpl;
import com.pms.pms.Dto.AppointmentDto;
import com.pms.pms.Entity.Appointment;
import com.pms.pms.Entity.User;
import com.pms.pms.Exception.ResourceNotFoundException;
import com.pms.pms.Repository.AppointmentRepository;
import com.pms.pms.Repository.UserRepository;
import com.pms.pms.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final UserRepository userRepository;

    @Override
    public Appointment createAppointment(AppointmentDto appointmentDto){
        User staff = userRepository.findById(appointmentDto.getStaffId()).get();
        User intern = userRepository.findById(appointmentDto.getInternId()).get();
        Appointment appointment = new Appointment();
        appointment.setStartTime(appointmentDto.getStartDate());
        appointment.setEndTime(appointmentDto.getEndDate());
        appointment.setStaff(staff);
        appointment.setIntern(intern);
        appointment.setPurpose(appointmentDto.getPurpose());
        return appointmentRepository.save(appointment);
    }


   @Override
    public List<Appointment> getAllAppointment() {
// TODO Auto-generated method stub
        return appointmentRepository.findAll();
    }

  @Override
    public Appointment getAppointmentByUser(Long userId) {

        Optional<Appointment> appointment = appointmentRepository.findById(userId);
        if (appointment.isPresent()) {
            return appointment.get();
        } else {
            throw new ResourceNotFoundException("User", "id", userId);
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
