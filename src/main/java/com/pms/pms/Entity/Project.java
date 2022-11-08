package com.pms.pms.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String project_title;

    private String description;

    @ManyToOne
    @JoinColumn(name = "projectId",referencedColumnName = "id")
    private Staff staff;

    @OneToOne
    @JoinColumn(name = "internId")
    private Intern Intern;

    @OneToMany(mappedBy = "")
    private Appointment appointment;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments;

}
