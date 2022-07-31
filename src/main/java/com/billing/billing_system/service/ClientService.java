package com.billing.billing_system.service;

import com.billing.billing_system.handle.ApiException;
import com.billing.billing_system.model.ClientEntity;
import com.billing.billing_system.model.ClientRequest;
import com.billing.billing_system.model.ClientResponse;

import java.util.List;

public interface ClientService {
    ClientEntity findOneByDni(Long dni);

    List<ClientEntity> findByLastname(String lastname);

    ClientEntity findOneByClientId(Long id);

    List<ClientEntity> findAllClient();

    ClientResponse createClient(ClientRequest newClient) throws ApiException;

    void deleteClientById(Long id);
}
