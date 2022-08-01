package com.billing.billing_system.builder;

import com.billing.billing_system.model.ClientModel.ClientEntity;
import com.billing.billing_system.model.ClientModel.ClientRequestDto;
import com.billing.billing_system.model.ClientModel.ClientResponseDto;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ClientBuilder extends EntityTransform<ClientResponseDto, ClientRequestDto, ClientEntity> {

    @Override
    public ClientResponseDto entityToResponse(ClientEntity client) {
        if(Objects.isNull(client)) return null;

        return ClientResponseDto.builder()
                .dni(client.getDni())
                .firstname(client.getFirstname())
                .lastname(client.getLastname())
                .email(client.getEmail())
                .id(client.getId())
                .build();
    }


    @Override
    public ClientEntity requestToEntity(ClientRequestDto client) {
        if(Objects.isNull(client)) return null;

        return ClientEntity.builder()
                .dni(client.getDni())
                .firstname(client.getFirstname())
                .lastname(client.getLastname())
                .email(client.getEmail())
                .build();
    }
}
