package com.pms.pms.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Staff")
public class Staff{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    private String password;

    @Column(name = "phone")
    private String phone;

    @OneToMany(mappedBy = "staff")
    private List<Intern> interns;

    @OneToMany(mappedBy = "staff")
    private List<Project> projects;

    @OneToMany(mappedBy = "staff")
    private List<Appointment> appointments;

//    @OneToMany(mappedBy = "staff")
//    private List<Comment> comments;

}

