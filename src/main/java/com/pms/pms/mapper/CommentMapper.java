package com.pms.pms.mapper;

import com.pms.pms.Dto.CommentDto;
import com.pms.pms.Entity.Comment;
import lombok.Builder;

@Builder
public class CommentMapper {

    public static CommentDto mapToCommentDto(CommentDto commentDto){
        return CommentDto.builder()
                .id(commentDto.getId())
                .title(commentDto.getTitle())
                .project(commentDto.getProject())
                .message(commentDto.getMessage())
                .build();
    }

    public static Comment mapToComment(Comment comment){

        return Comment.builder()
                .id(comment.getId())
                .title(comment.getTitle())
                .message(comment.getMessage())
                .project(comment.getProject())
                .build();
    }
}
