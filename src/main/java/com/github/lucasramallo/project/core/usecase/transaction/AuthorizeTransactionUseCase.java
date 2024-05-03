package com.github.lucasramallo.project.core.usecase.transaction;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthorizeTransactionUseCase {

    public Boolean execute() {
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://run.mocky.io/v3/5794d450-d2e2-4412-8131-73d0293ac1cc";

        String message = restTemplate.getForObject(url, JsonNode.class).get("message").asText();

        return message.equals("Autorizado");
    }
}
