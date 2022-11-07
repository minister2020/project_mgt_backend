package com.pms.pms.mapper;

import com.pms.pms.Dto.InternDto;
import com.pms.pms.Dto.StaffDto;
import com.pms.pms.Entity.Intern;
import com.pms.pms.Entity.Staff;
import lombok.Builder;


@Builder
public class StaffMapper {
    public static StaffDto mapToStaffDto(Staff Staff) {

        return StaffDto.builder()
                .id(Staff.getId())
                .firstName(Staff.getFirstName())
                .lastName(Staff.getLastName())
                .phone(Staff.getPhone())
                .appointments(Staff.getAppointments())
                .email(Staff.getEmail())
                .password(Staff.getPassword())
                .projects(Staff.getProjects())
                .interns(Staff.getInterns())
                .build();


    }

     public static Staff mapToStaff(StaffDto staffDto){

        return Staff.builder()
                .firstName(staffDto.getFirstName())
                .lastName(staffDto.getLastName())
                .email(staffDto.getEmail())
                .password(staffDto.getPassword())
                .phone(staffDto.getPhone())
                .projects(staffDto.getProjects())
                .appointments(staffDto.getAppointments())
                .projects(staffDto.getProjects())
                .interns(staffDto.getInterns())



                .build();
     }

}
