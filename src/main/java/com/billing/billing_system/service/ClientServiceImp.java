package com.billing.billing_system.service;

import com.billing.billing_system.model.ClientEntity;
import com.billing.billing_system.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImp implements ClientService {

    private final ClientRepository clientRepository;

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
    public ClientEntity createClient(ClientEntity newClient) {
        return clientRepository.save(newClient);
    }

    @Override
    public void deleteClientById(Long id) {
        clientRepository.deleteById(id);
    }

}
