package com.billing.billing_system.controller;

import com.billing.billing_system.handle.ApiException;
import com.billing.billing_system.model.ClientEntity;
import com.billing.billing_system.model.ClientRequest;
import com.billing.billing_system.model.ClientResponse;
import com.billing.billing_system.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("client")
public class ClientController {

    private final ClientService clientService;

    @PostMapping("create")
    public ResponseEntity<ClientResponse> createClient(@Valid @RequestBody ClientRequest newClient) throws ApiException {
        return ResponseEntity.ok(clientService.createClient(newClient));
    }

    @GetMapping("all")
    public ResponseEntity<List<ClientEntity>> findAll() {
        return ResponseEntity.ok(clientService.findAllClient());
    }

    @GetMapping("get-by-dni/{dni}")
    public ResponseEntity<ClientEntity> getAllClientByDni(@PathVariable Long dni) {
        return  ResponseEntity.ok(clientService.findOneByDni(dni));
    }

    @GetMapping("get-by-lastname/{lastname}")
    public ResponseEntity<List<ClientEntity>> getClientByLastname(@PathVariable String lastname) {
        return  ResponseEntity.ok(clientService.findByLastname(lastname));
    }

    @DeleteMapping("delete-by-id/{id}")
    public ResponseEntity deleteClient (@PathVariable Long id){
        clientService.deleteClientById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
