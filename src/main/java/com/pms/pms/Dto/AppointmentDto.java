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
    private String startDate;
    private String endDate;
    private String purpose;
    private long internId;
    private long staffId;
}
