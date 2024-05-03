package com.github.lucasramallo.project.core.service;

import com.github.lucasramallo.project.core.domain.customer.Customer;
import com.github.lucasramallo.project.core.dtos.EmailRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmailService {
    @Autowired
    private RestTemplate restTemplate;

    public void sendEmail(Customer custumer, String message) {
        String email = custumer.getEmail();
        EmailRequestDTO emailRequestDTO = new EmailRequestDTO(email, message);
        String serviceUrl = "https://run.mocky.io/v3/54dc2cf1-3add-45b5-b5a9-6bf7e7f1f4a6";

        ResponseEntity<String> response = restTemplate.postForEntity(serviceUrl, emailRequestDTO, String.class);

        validate(response);
    }

    private void validate(ResponseEntity<String> response) {
        if (!(response.getStatusCode() == HttpStatus.OK)) {
            throw new RuntimeException("email not sent");
        };

        System.out.println("Eamil enviado!");
    }
}
