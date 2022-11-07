package com.pms.pms.Dto;

import com.pms.pms.Entity.Comment;
import com.pms.pms.Entity.Staff;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {

    private Long id;
    private String project_title;
    private String description;
    private Staff staff;
   private Set<Comment> comments;

}
