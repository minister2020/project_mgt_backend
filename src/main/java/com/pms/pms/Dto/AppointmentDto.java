package com.pms.pms.Dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDto {
    private String start;
    private String endApp;
    private long internId;
    private long staffId;
}
