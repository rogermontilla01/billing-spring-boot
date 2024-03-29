package com.billing.billing_system.repository;

import com.billing.billing_system.model.ClientModel.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
    ClientEntity findOneById(Long id);

    ClientEntity findOneByDni(Long dni);

    List<ClientEntity> findByLastname(String lastname);

    void deleteById(Long id);

    Boolean existsByDni(Long dni);
}
