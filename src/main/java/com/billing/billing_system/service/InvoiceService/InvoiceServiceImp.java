package com.billing.billing_system.service.InvoiceService;

import com.billing.billing_system.builder.InvoiceBuilder;
import com.billing.billing_system.handle.ApiException;
import com.billing.billing_system.model.ClientModel.ClientEntity;
import com.billing.billing_system.model.InvoiceModel.InvoiceEntity;
import com.billing.billing_system.model.InvoiceModel.InvoiceRequestDto;
import com.billing.billing_system.model.InvoiceModel.InvoiceResponseDto;
import com.billing.billing_system.model.ProductModel.ProductInvoiceDto;
import com.billing.billing_system.model.SaleModel.SaleEntity;
import com.billing.billing_system.repository.InvoiceRepository;
import com.billing.billing_system.service.ClientService.ClientService;
import com.billing.billing_system.service.DateService.DateService;
import com.billing.billing_system.service.ProductService.ProductService;
import com.billing.billing_system.service.SaleService.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class InvoiceServiceImp implements InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final SaleService saleService;
    private final ClientService clientService;
    private final InvoiceBuilder invoiceBuilder;
    private final ProductService productService;
    private final DateService dateService;

    @Override
    public InvoiceResponseDto createInvoice(InvoiceRequestDto invoice) throws ApiException {
        try {
            Date date = dateService.getDate();

            InvoiceEntity createInvoice = new InvoiceEntity();
            List<SaleEntity> saleList = getSaleEntities(invoice);

            // Pass reference to de chile
            for (SaleEntity saleEntity : saleList) {
                saleEntity.setInvoiceId(createInvoice);
            }

            ClientEntity client = clientService.findOneClientByDni(invoice.getClientDni());

            BigDecimal total = getTotalInvoice(saleList);

            createInvoice.setDate(date);
            createInvoice.setTotal(total);
            createInvoice.setClient(client);
            createInvoice.setSales(saleList);

            InvoiceEntity invoiceSaved = invoiceRepository.save(createInvoice);
            return invoiceBuilder.entityToResponse(invoiceSaved);
        } catch (Exception error) {
            throw new ApiException(error.getMessage());
        }
    }

    @Override
    public InvoiceResponseDto findOneById(Long id) throws ApiException {
        InvoiceEntity result = invoiceRepository.findById(id).orElse(null);
        return invoiceBuilder.entityToResponse(result);
    }

    @Override
    public List<InvoiceResponseDto> findAll() throws ApiException {
        List<InvoiceEntity> allInvoice = invoiceRepository.findAll();
        return invoiceBuilder.entityToResponseList(allInvoice);
    }


    private BigDecimal getTotalInvoice(List<SaleEntity> saleList) {
        return saleList.stream()
                .map((item) -> item.getPrice().multiply(new BigDecimal(item.getQuantity())))
                .reduce(BigDecimal::add)
                .orElse(new BigDecimal("0"));
    }

    private List<SaleEntity> getSaleEntities(InvoiceRequestDto invoice) throws ApiException {
        List<ProductInvoiceDto> invoiceProduct = invoice.getProduct();
        List<SaleEntity> saleEntityList = invoiceProduct.stream().map(
                this::mapSaleEntity
        ).collect(Collectors.toList());

        return updateProductQuantity(invoiceProduct, saleEntityList);
    }

    private List<SaleEntity> updateProductQuantity(List<ProductInvoiceDto> invoiceProductDto, List<SaleEntity> saleEntityList) throws ApiException {
        if(saleEntityList.size() > 0) {
            for (ProductInvoiceDto product: invoiceProductDto) {
                productService.updateProductQuantity(product);
            }
            return saleEntityList;
        } else {
            throw new ApiException("There was a problem invoicing products...");
        }
    }

    private SaleEntity mapSaleEntity(ProductInvoiceDto product) {
        try {
            return saleService.createSaleEntity(product);
        } catch (ApiException ex) {
            throw new RuntimeException(ex);
        }
    }
}
