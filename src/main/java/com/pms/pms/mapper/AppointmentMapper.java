package com.pms.pms.mapper;

import com.pms.pms.Dto.AppointmentDto;
import com.pms.pms.Entity.Appointment;
import lombok.Builder;

@Builder
public class AppointmentMapper {
    public static AppointmentDto mapToAppointmentDto(Appointment appointment){

        return AppointmentDto.builder()
                .id(appointment.getId())
                .start(appointment.getStart())
                .endApp(appointment.getEndApp())
                .canceledAt(appointment.getCanceledAt())
                .comment(appointment.getComment())
                .intern(appointment.getIntern())
                .staff(appointment.getStaff())
                .build();
    }

    public static Appointment mapToAppointment(AppointmentDto appointmentDto){
        return Appointment.builder()
                .id(appointmentDto.getId())
                .start(appointmentDto.getStart())
                .endApp(appointmentDto.getEndApp())
                .canceledAt(appointmentDto.getCanceledAt())
                .intern(appointmentDto.getIntern())
                .staff(appointmentDto.getStaff())
                .comment(appointmentDto.getComment())
                .build();
    }
}
