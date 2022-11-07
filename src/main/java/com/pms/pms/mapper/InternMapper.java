package com.pms.pms.mapper;

import com.pms.pms.Dto.InternDto;
import com.pms.pms.Entity.Intern;
import lombok.Builder;

@Builder
public class InternMapper {
     public static InternDto mapToInternDto(Intern intern){
      // collect data from DB
         return InternDto.builder()
                 .id(intern.getId())
                 .firstName(intern.getFirstName())
                 .lastName(intern.getLastName())
                 .phone(intern.getPhone())
                 .staff(intern.getStaff())
                 .email(intern.getEmail())
                 .password(intern.getPassword())
                 .appointments(intern.getAppointments())
                 .build();
     }

     public static Intern mapToIntern(InternDto internDto){

         //send data to the DB
         return  Intern.builder()
                // .id(internDto.getId())
                 .firstName(internDto.getFirstName())
                 .lastName(internDto.getLastName())
                 .email(internDto.getEmail())
                 .password(internDto.getPassword())
                 .appointments(internDto.getAppointments())
                 .phone(internDto.getPhone())
                 .staff(internDto.getStaff())
                 .build();

     }
}
