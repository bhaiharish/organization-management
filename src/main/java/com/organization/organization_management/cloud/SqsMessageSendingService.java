package com.organization.organization_management.cloud;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.organization.organization_management.model.AppraisalResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class SqsMessageSendingService {
    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    public void send(String queue, AppraisalResult result) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonMessage = objectMapper.writeValueAsString(result);
            queueMessagingTemplate.convertAndSend(queue, jsonMessage);
        } catch (Exception e) {
            System.out.println("unable to convert message to desired format");
        }
    }
}
