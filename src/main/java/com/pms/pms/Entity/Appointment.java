package com.pms.pms.Entity;
;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Appointment")
public class Appointment  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @DateTimeFormat(pattern = " yyyy-MM-dd Hh: MM: ss")
    @Column(name = "startTime")
    private String startTime;


   @DateTimeFormat(pattern = "yyyy-MM-dd Hh: MM: ss")
    @Column(name = "endTime")
    private String endTime;

   private User user;










}
