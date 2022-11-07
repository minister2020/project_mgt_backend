package com.pms.pms.Dto;

import com.pms.pms.Entity.Appointment;
import com.pms.pms.Entity.Intern;
import com.pms.pms.Entity.Staff;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InternDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private Staff staff;
    private List<Appointment> appointments;
//    private String appointments;
}
