package com.billing.billing_system.service.SaleService;

import com.billing.billing_system.builder.SaleBuilder;
import com.billing.billing_system.handle.ApiException;
import com.billing.billing_system.model.SaleModel.SaleEntity;
import com.billing.billing_system.model.SaleModel.SaleRequestDto;
import com.billing.billing_system.model.SaleModel.SaleResponseDto;
import com.billing.billing_system.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleServiceImp implements SaleService {

    private final SaleRepository saleRepository;
    private final SaleBuilder saleBuilder;

    @Override
    public SaleResponseDto createSale(SaleRequestDto newSaleEntity) throws ApiException {
        try {
            //TODO: is necessary add a validation?
            //TODO: find a way to make transactions and create invoices...

            SaleEntity saleEntity = saleRepository.save(saleBuilder.requestToEntity(newSaleEntity));

            return saleBuilder.entityToResponse(saleEntity);
        } catch (Exception error) {
            throw new ApiException(error.getMessage());
        }
    }

    @Override
    public SaleResponseDto findOneById(Long id) throws ApiException {
        try {
            return saleBuilder.entityToResponse(saleRepository.findOneById(id));
        } catch (Exception error) {
            throw new ApiException(error.getMessage());
        }
    }

    @Override
    public List<SaleResponseDto> findAll() throws ApiException {
        try {
            return saleBuilder.entityToResponseList(saleRepository.findAll());
        } catch (Exception error) {
            throw new ApiException(error.getMessage());
        }
    }

    @Override
    public void deleteById(Long id) throws ApiException {
        try {
            saleRepository.deleteById(id);
        } catch (Exception error) {
            throw new ApiException(error.getMessage());
        }

    }
}
