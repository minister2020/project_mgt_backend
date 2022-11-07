package com.pms.pms.Dto;


import lombok.Data;

@Data
public class SignUpDto {
    private String firstName;
    private String lastName ;
    private String phone;
    private String email;
    private String password;
}
