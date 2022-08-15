package com.billing.billing_system.service.ClientService;

import com.billing.billing_system.builder.ClientBuilder;
import com.billing.billing_system.handle.ApiException;
import com.billing.billing_system.model.ClientModel.ClientEntity;
import com.billing.billing_system.model.ClientModel.ClientRequestDto;
import com.billing.billing_system.model.ClientModel.ClientResponseDto;
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
    public ClientResponseDto findOneByDni(Long dni) throws ApiException {
        try {
            return clientBuilder.entityToResponse(clientRepository.findOneByDni(dni));
        } catch (Exception error) {
            throw new ApiException(error.getMessage());
        }
    }

    @Override
    public ClientEntity findOneClientById(Long id) throws ApiException {
        try {
            return clientRepository.findOneById(id);
        } catch (Exception error) {
            throw new ApiException(error.getMessage());
        }
    }

    @Override
    public ClientEntity findOneClientByDni(Long dni) throws ApiException {
        try {
            ClientEntity client = clientRepository.findOneByDni(dni);
            if (client == null) {
                throw new Exception("Client does not exist...");
            }
            return client;
        } catch (Exception error) {
            throw new ApiException(error.getMessage());
        }
    }

    @Override
    public List<ClientResponseDto> findByLastname(String lastname) throws ApiException {
        try {
            return clientBuilder.entityToResponseList(clientRepository.findByLastname(lastname));
        } catch (Exception error) {
            throw new ApiException(error.getMessage());
        }

    }

    @Override
    public ClientResponseDto findOneByClientId(Long id) throws ApiException {
        try {
            return clientBuilder.entityToResponse(clientRepository.findOneById(id));
        } catch (Exception error) {
            throw new ApiException(error.getMessage());
        }

    }

    @Override
    public List<ClientResponseDto> findAllClient() throws ApiException {
        try {
            return clientBuilder.entityToResponseList(clientRepository.findAll());
        } catch (Exception error) {
            throw new ApiException(error.getMessage());
        }
    }

    @Override
    public ClientResponseDto createClient(ClientRequestDto newClient) throws ApiException {
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
    public void deleteClientById(Long id) throws ApiException {
        try {
            clientRepository.deleteById(id);
        } catch (Exception error) {
            throw new ApiException(error.getMessage());
        }
    }
}
