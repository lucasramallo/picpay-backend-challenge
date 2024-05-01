package com.github.lucasramallo.project.presenter.api;

import com.github.lucasramallo.project.core.dtos.TransferRequestDTO;
import com.github.lucasramallo.project.core.usecase.transfer.TransferUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    private TransferUseCase transferUseCase;

//    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Void> transfer(@RequestBody TransferRequestDTO transferRequestDTO, UriComponentsBuilder uriComponentsBuilder) {
//        String transactionId = transferUseCase.execute(transferRequestDTO);
//
//        var uri = uriComponentsBuilder.path("/transaction/{id}").buildAndExpand(transactionId).toUri();
//
//        return ResponseEntity.created(uri).build(); // ou HttpStatus.CREATED
//    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> transfer(@RequestBody TransferRequestDTO transferRequestDTO) {
        transferUseCase.execute(transferRequestDTO);


        return new ResponseEntity<>(HttpStatus.CREATED);// ou HttpStatus.CREATED
    }
}
