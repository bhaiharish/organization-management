package com.organization.organization_management.repository;

import com.organization.organization_management.model.AppraisalResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppraisalResultRepository extends JpaRepository<AppraisalResult, String> {
}
