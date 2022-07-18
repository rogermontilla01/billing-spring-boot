package com.billing.billing_system.service;

import com.billing.billing_system.model.ClientEntity;

import java.util.List;

public interface ClientService {
    ClientEntity findOneByDni(Long dni);

    List<ClientEntity> findByLastname(String lastname);

    ClientEntity findOneByClientId(Long id);

    List<ClientEntity> findAllClient();

    ClientEntity createClient(ClientEntity newClient);

    void deleteClientById(Long id);
}
