package com.organization.organization_management.cloud;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.organization.organization_management.model.AppraisalRequest;
import com.organization.organization_management.service.SlabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Service;

@Service
public class SqsMessageReceiverService {
    @Autowired
    SlabService slabService;

    @SqsListener("appraisal-request-to-org-queue")
    public void appraisalRequestReceiver(String message) throws JsonProcessingException {
        System.out.println("Queue Messages: " + message);
        ObjectMapper objectMapper = new ObjectMapper();
        AppraisalRequest request = objectMapper.readValue(message, AppraisalRequest.class);
        System.out.println("successfully mapped to model");
        slabService.validateSalaryLevel(request);
    }

}
