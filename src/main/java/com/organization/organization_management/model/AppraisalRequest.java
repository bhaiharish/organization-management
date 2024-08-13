package com.organization.organization_management.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AppraisalRequest {
    private String emp_no;
    private Integer new_salary;
    private String title;

}
