package com.billing.billing_system.service.ClientService;

import com.billing.billing_system.handle.ApiException;
import com.billing.billing_system.model.ClientModel.ClientEntity;
import com.billing.billing_system.model.ClientModel.ClientRequestDto;
import com.billing.billing_system.model.ClientModel.ClientResponseDto;

import java.util.List;

public interface ClientService {
    ClientResponseDto findOneByDni(Long dni) throws ApiException;

    ClientEntity findOneClientById(Long id) throws ApiException;

    ClientEntity findOneClientByDni(Long dni) throws ApiException;

    List<ClientResponseDto> findByLastname(String lastname) throws ApiException;

    ClientResponseDto findOneByClientId(Long id) throws ApiException;

    List<ClientResponseDto> findAllClient() throws ApiException;

    ClientResponseDto createClient(ClientRequestDto newClient) throws ApiException;

    void deleteClientById(Long id) throws ApiException;
}
