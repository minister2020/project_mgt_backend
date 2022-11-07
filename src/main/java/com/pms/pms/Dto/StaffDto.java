package com.pms.pms.Dto;

import com.pms.pms.Entity.Appointment;
import com.pms.pms.Entity.Intern;
import com.pms.pms.Entity.Project;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class StaffDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private List<Intern> interns;
    private List<Project> projects;
    private List<Appointment> appointments;

}
