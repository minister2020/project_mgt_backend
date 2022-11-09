package com.pms.pms.Dto;

import com.pms.pms.Entity.Comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {

    private Long id;
    private String project_title;
    private String description;

   private Set<Comment> comments;

}
