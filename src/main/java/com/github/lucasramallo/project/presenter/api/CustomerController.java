package com.github.lucasramallo.project.presenter.api;

import com.github.lucasramallo.project.core.dtos.CustomerRequestDTO;
import com.github.lucasramallo.project.core.usecase.customer.CreateCustomerUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CreateCustomerUseCase createCustomerUseCase;

    @PostMapping()
    public ResponseEntity<String> createCustomer(@RequestBody CustomerRequestDTO customerRequestDTO, UriComponentsBuilder uriComponentsBuilder) {
        createCustomerUseCase.execute(customerRequestDTO);

        var uri = uriComponentsBuilder.path("/customer/{document}").buildAndExpand(customerRequestDTO.document()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
