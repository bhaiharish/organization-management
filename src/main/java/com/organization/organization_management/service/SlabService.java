package com.organization.organization_management.service;

import com.organization.organization_management.cloud.SqsMessageSendingService;
import com.organization.organization_management.model.AppraisalRequest;
import com.organization.organization_management.model.AppraisalResult;
import com.organization.organization_management.model.Slab;
import com.organization.organization_management.repository.AppraisalResultRepository;
import com.organization.organization_management.repository.SlabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class SlabService {

    private static final String SQS_SENDER_URL = "https://sqs.ap-south-1.amazonaws.com/339712861729/appraisal-result-queue";
    @Autowired
    SlabRepository slabRepository;
    @Autowired
    AppraisalResultRepository appraisalResultRepository;
    @Autowired
    SqsMessageSendingService sqsMessageSendingService;

    public Slab addSlab(Slab slab) {
        return slabRepository.save(slab);
    }

    public Slab updateSlab(Slab slab) {
        return slabRepository.save(slab);
    }

    public AppraisalResult validateSalaryLevel(AppraisalRequest request) {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = today.format(formatter);

        List<Slab> slabs = slabRepository.findByTitle(request.getTitle());
        Slab slab = slabs.stream().findFirst().get();
        AppraisalResult.AppraisalResultBuilder builder = AppraisalResult.builder();
        builder.id(request.getEmp_no()+"_"+formattedDate).emp_no(request.getEmp_no());

        if(slab.getLower_limit() > request.getNew_salary()) {
            builder.result("NOT_APPROVED").comments("this salary is less that lower limit ");
        }
        if(slab.getUpper_limit() < request.getNew_salary()) {
            builder.result("NOT_APPROVED").comments("this salary is greater that upper limit ");
        }
        builder.result("APPROVED").comments("approved");

        AppraisalResult appraisalResult = builder.build();
        appraisalResultRepository.save(appraisalResult);
        sqsMessageSendingService.send(SQS_SENDER_URL, appraisalResult);
        return appraisalResult;
    }
}
