package com.pms.pms.Dto;

import com.pms.pms.Entity.Comment;
import com.pms.pms.Entity.Intern;
import com.pms.pms.Entity.Staff;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDto {

    @Id

    private Long id;

    private LocalDateTime start;

    private LocalDateTime endApp;

    private LocalDateTime canceledAt;

    private Intern intern;

    private Staff staff;

    private List<Comment> comment;
}
