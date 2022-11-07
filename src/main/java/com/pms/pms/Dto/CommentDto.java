package com.pms.pms.Dto;

import com.pms.pms.Entity.Project;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDto {

    private Long id;

    private String title;

    private String message;

    private Project project;
}
