package com.billing.billing_system.controller;

import com.billing.billing_system.handle.ApiException;
import com.billing.billing_system.model.ClientModel.ClientRequestDto;
import com.billing.billing_system.model.ClientModel.ClientResponseDto;
import com.billing.billing_system.service.ClientService.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("client")
public class ClientController {

    private final ClientService clientService;

    @PostMapping("create")
    public ResponseEntity<ClientResponseDto> createClient(@Valid @RequestBody ClientRequestDto newClient) throws ApiException {
        return ResponseEntity.ok(clientService.createClient(newClient));
    }

    @GetMapping("all")
    public ResponseEntity<List<ClientResponseDto>> findAll() throws ApiException {
        return ResponseEntity.ok(clientService.findAllClient());
    }

    @GetMapping("get-by-dni/{dni}")
    public ResponseEntity<ClientResponseDto> getAllClientByDni(@PathVariable Long dni) throws ApiException {
        return  ResponseEntity.ok(clientService.findOneByDni(dni));
    }

    @GetMapping("get-by-lastname/{lastname}")
    public ResponseEntity<List<ClientResponseDto>> getClientByLastname(@PathVariable String lastname) throws ApiException {
        return  ResponseEntity.ok(clientService.findByLastname(lastname));
    }

    @DeleteMapping("delete-by-id/{id}")
    public ResponseEntity deleteClient (@PathVariable Long id) throws ApiException {
        clientService.deleteClientById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
