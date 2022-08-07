package com.billing.billing_system.service.InvoiceService;

import com.billing.billing_system.builder.InvoiceBuilder;
import com.billing.billing_system.handle.ApiException;
import com.billing.billing_system.model.ClientModel.ClientEntity;
import com.billing.billing_system.model.InvoiceModel.CreateInvoiceDto;
import com.billing.billing_system.model.InvoiceModel.InvoiceEntity;
import com.billing.billing_system.model.InvoiceModel.InvoiceRequestDto;
import com.billing.billing_system.model.InvoiceModel.InvoiceResponseDto;
import com.billing.billing_system.model.ProductModel.ProductInvoiceDto;
import com.billing.billing_system.model.SaleModel.SaleEntity;
import com.billing.billing_system.repository.InvoiceRepository;
import com.billing.billing_system.service.ClientService.ClientService;
import com.billing.billing_system.service.SaleService.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class InvoiceServiceImp implements InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final SaleService saleService;
    private final ClientService clientService;
    private final InvoiceBuilder invoiceBuilder;

    @Override
    public InvoiceEntity createInvoice(InvoiceRequestDto invoice) throws ApiException {
        try {
            List<SaleEntity> saleList = getSaleEntities(invoice);
            ClientEntity client = clientService.findOneClientById(invoice.getClientId());
            CreateInvoiceDto createInvoice = getCreateInvoiceDto(saleList, client);
            InvoiceEntity invoiceEntity = invoiceBuilder.createInvoiceToEntity(createInvoice);

            return invoiceRepository.save(invoiceEntity);
        } catch (Exception error) {
            throw new ApiException(error.getMessage());
        }
    }

    @Override
    public InvoiceResponseDto findOneById(Long id) throws ApiException {
        return null;
    }

    @Override
    public List<InvoiceResponseDto> findAll() throws ApiException {
        return null;
    }

    private CreateInvoiceDto getCreateInvoiceDto(List<SaleEntity> saleList, ClientEntity client) {
        BigDecimal total = getTotalInvoice(saleList);
        CreateInvoiceDto createInvoice = new CreateInvoiceDto();

        createInvoice.setTotal(total);
        createInvoice.setClientId(client);
        createInvoice.setSales(saleList);
        return createInvoice;
    }

    private BigDecimal getTotalInvoice(List<SaleEntity> saleList) {
        return saleList.stream()
                .map((item) -> item.getPrice().multiply(new BigDecimal(item.getQuantity())))
                .reduce(BigDecimal::add)
                .orElse(new BigDecimal("0"));
    }

    private List<SaleEntity> getSaleEntities(InvoiceRequestDto invoice) {
        return invoice.getProduct().stream().map(
                this::mapSaleEntity
        ).collect(Collectors.toList());
    }

    private SaleEntity mapSaleEntity(ProductInvoiceDto product) {
        try {
            return saleService.createSale(product);
        } catch (ApiException ex) {
            throw new RuntimeException(ex);
        }
    }
}
