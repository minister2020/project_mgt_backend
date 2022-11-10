package com.pms.pms.Dto;

import com.pms.pms.Entity.Role;
import lombok.Data;

@Data

public class SignUpDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private Role role;
}
