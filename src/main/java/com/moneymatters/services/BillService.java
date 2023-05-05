package com.moneymatters.services;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moneymatters.data.dtos.BillDto;
import com.moneymatters.data.models.Bill;
import com.moneymatters.repositories.BillRepository;

@Service
public class BillService {

    private final BillRepository billRepository;

    @Autowired
    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public Iterable<Bill> getAll() {
        return billRepository.findAll();
    }

    public Bill getById(Long id) {
        return billRepository.getReferenceById(id);
    }

    public Bill store(BillDto billDto) {
        BillDto a = new BillDto(billDto.getPrice(), billDto.getName(), billDto.getDescription(),
                billDto.getPaymentType(), billDto.getInstallments(), billDto.getDueDate());
        return billRepository.save(convertDtoToBill(new Bill(), a));
    }

    public Bill update(Long id, BillDto billDto) {
        Bill bill = getById(id);
        return billRepository.save(convertDtoToBill(bill, billDto));
    }

    Bill convertDtoToBill(Bill bill, BillDto billDto) {

        bill.setDescription(billDto.getDescription());
        Date date = Date.valueOf(billDto.getDueDate());
        bill.setDueDate(date);
        bill.setInstallments(billDto.getInstallments());
        bill.setName(billDto.getName());
        bill.setPaymentType(billDto.getPaymentType());
        bill.setPrice(billDto.getPrice());

        return bill;
    }

}
