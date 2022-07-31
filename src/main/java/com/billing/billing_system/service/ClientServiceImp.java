package com.billing.billing_system.service;

import com.billing.billing_system.builder.ClientBuilder;
import com.billing.billing_system.handle.ApiException;
import com.billing.billing_system.model.ClientEntity;
import com.billing.billing_system.model.ClientRequest;
import com.billing.billing_system.model.ClientResponse;
import com.billing.billing_system.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImp implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientBuilder clientBuilder;

    @Override
    public ClientEntity findOneByDni(Long dni) {
        return clientRepository.findOneByDni(dni);
    }

    @Override
    public List<ClientEntity> findByLastname(String lastname) {
        return clientRepository.findByLastname(lastname);
    }

    @Override
    public ClientEntity findOneByClientId(Long id) {
        return clientRepository.findOneById(id);
    }

    @Override
    public List<ClientEntity> findAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public ClientResponse createClient(ClientRequest newClient) throws ApiException {
        try {
            if (clientRepository.existsByDni(newClient.getDni())) {
                throw new ApiException(String.format("Client with dni %s already exist...", newClient.getDni()));
            }

            ClientEntity clientEntity = clientRepository.save(clientBuilder.requestToEntity(newClient));

            return clientBuilder.entityToResponse(clientEntity);
        } catch (Exception error) {
            throw new ApiException(error.getMessage());
        }

    }

    @Override
    public void deleteClientById(Long id) {
        clientRepository.deleteById(id);
    }

}
