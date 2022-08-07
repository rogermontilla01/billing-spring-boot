package com.billing.billing_system.repository;

import com.billing.billing_system.model.InvoiceModel.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Long> {

}
