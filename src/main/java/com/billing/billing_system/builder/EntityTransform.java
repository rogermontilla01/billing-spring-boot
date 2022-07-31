package com.billing.billing_system.builder;

import java.util.List;

public interface EntityTransform<T, U, E> {
     T entityToResponse(E entity);
     List<T> entityToResponseList(List<E> clientList);
     E requestToEntity(U response);
}
