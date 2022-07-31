package com.billing.billing_system.builder;

import com.billing.billing_system.model.ClientEntity;
import com.billing.billing_system.model.ClientRequest;
import com.billing.billing_system.model.ClientResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ClientBuilder implements EntityTransform<ClientResponse, ClientRequest, ClientEntity> {

    @Override
    public ClientResponse entityToResponse(ClientEntity client) {
        if(Objects.isNull(client)) return null;

        return ClientResponse.builder()
                .dni(client.getDni())
                .firstname(client.getFirstname())
                .lastname(client.getLastname())
                .id(client.getId())
                .build();
    }

    @Override
    public List<ClientResponse> entityToResponseList(List<ClientEntity> clientList) {
        return clientList.stream().map(this::entityToResponse).collect(Collectors.toList());
    }

    @Override
    public ClientEntity requestToEntity(ClientRequest client) {
        if(Objects.isNull(client)) return null;

        return ClientEntity.builder()
                .dni(client.getDni())
                .firstname(client.getFirstname())
                .lastname(client.getLastname())
                .email(client.getEmail())
                .build();
    }
}
