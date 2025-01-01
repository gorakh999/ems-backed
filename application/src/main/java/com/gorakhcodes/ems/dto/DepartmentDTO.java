package com.gorakhcodes.ems.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
    private Long id;
    private String departmentName;
    private String departmentDescription;
}
