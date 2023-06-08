package com.moneymatters.services;

import com.moneymatters.data.dtos.SaleDto;
import com.moneymatters.data.mappers.SaleDtoMapper;
import com.moneymatters.data.models.Sale;
import com.moneymatters.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SaleService {

    private final SaleRepository saleRepository;

    @Autowired
    SaleService(SaleRepository saleRepository, UserService userService) {
        this.saleRepository = saleRepository;
    }

    public Page<Sale> getAllPaged(Pageable pageable) {
        return saleRepository.findAll(pageable);

    }

    public Double getTodaySales() {
        return saleRepository.getTodaySales();
    }

    public Sale getById(Long id) {
        return saleRepository.getReferenceById(id);
    }

    public Integer getSalesComparedToPastMonth() {
        String[] sales = saleRepository.getSalesComparedToPastMonth().split(",");
        return Integer.parseInt(sales[0]) - Integer.parseInt(sales[1]);
    }

    public Sale store(SaleDto saleDto) {
        Sale sale = SaleDtoMapper.INSTANCE.toSale(saleDto);
        return saleRepository.save(sale);
    }

    public Sale update(Boolean status, Long id) {
        Sale sale = getById(id);
        sale.setStatus(status);
        return saleRepository.save(sale);
    }

    public void delete(Long id) {
        saleRepository.deleteById(id);
    }

}