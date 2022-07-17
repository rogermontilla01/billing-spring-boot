package com.billing.billing_system.controller;

import com.billing.billing_system.model.ClientEntity;
import com.billing.billing_system.service.ClientService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("client")
public class ClientController {

    private final ClientService clientService;

    @PostMapping("create")
    public ResponseEntity<ClientEntity> createClient(@RequestBody ClientEntity newClient) {
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
    public void deleteClient (@PathVariable Long id){
        clientService.deleteClientById(id);
    }
}
