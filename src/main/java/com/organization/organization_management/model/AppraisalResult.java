package com.organization.organization_management.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "appraisal_result")
@Builder
@Getter
@Setter
public class AppraisalResult {
    @Id
    private String id;
    private String emp_no;

    private String result;

    private String comments;

}
