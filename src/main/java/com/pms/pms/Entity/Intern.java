package com.pms.pms.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Intern")
public class Intern {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @Column(name = "first_name")
//    private String firstName;
//
//    @Column(name = "last_name")
//    private String lastName;
//
//    @Column(name = "email")
//    private String email;
//
//    private String password;
//
//    @Column(name = "phone")
//    private String phone;
//
//    @ManyToOne
//    @JoinColumn(name ="staffId", referencedColumnName = "id")
//    private Staff staff;
//
//    @OneToMany(mappedBy = "intern")
//    private List<Appointment> appointments;


}
