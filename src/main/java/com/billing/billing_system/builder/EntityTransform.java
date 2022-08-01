package com.billing.billing_system.builder;

import java.util.List;
import java.util.stream.Collectors;

public abstract class EntityTransform<T, U, E> {
     public abstract T entityToResponse(E entity);

     public abstract E requestToEntity(U response);

     public List<T> entityToResponseList(List<E> clientList) {
          return clientList.stream().map(this::entityToResponse).collect(Collectors.toList());
     }
}
