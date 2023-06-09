package com.moneymatters.services;

import com.moneymatters.data.dtos.BillDto;
import com.moneymatters.data.mappers.BillDtoMapper;
import com.moneymatters.data.models.Bill;
import com.moneymatters.repositories.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class BillService {

    private final BillRepository billRepository;

    @Autowired
    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public Page<Bill> getAllPaged(String name, String description, String paymentType, Integer installments,
            Date dueDate, Pageable pageable) {

        if (null != name && !name.isEmpty()) {
            return getAllByNamePaged(name, pageable);
        } else if (null != description && !description.isEmpty()) {
            return getAllByDescriptionPaged(description, pageable);
        } else if (null != paymentType && !paymentType.isEmpty()) {
            return getAllByPaymentTypePaged(paymentType, pageable);
        } else if (null != installments && 0 >= installments) {
            return getAllByInstallmentsPaged(installments, pageable);
        } else if (null != dueDate) {
            return getAllByDueDatePaged(dueDate, pageable);
        }

        return billRepository.findAll(pageable);
    }

    private Page<Bill> getAllByDueDatePaged(Date dueDate, Pageable pageable) {
        return billRepository.findAllByDueDatePaged(dueDate, pageable);
    }

    private Page<Bill> getAllByInstallmentsPaged(Integer installments, Pageable pageable) {
        return billRepository.findAllByInstallmentsPaged(installments, pageable);
    }

    private Page<Bill> getAllByPaymentTypePaged(String paymentType, Pageable pageable) {
        return billRepository.findAllByPaymentTypePaged(paymentType, pageable);
    }

    private Page<Bill> getAllByDescriptionPaged(String description, Pageable pageable) {
        return billRepository.findAllByDescriptionPaged(description, pageable);
    }

    private Page<Bill> getAllByNamePaged(String name, Pageable pageable) {
        return billRepository.findAllByNamePaged(name, pageable);
    }

    public Bill getById(Long id) throws Exception {
        if (null == id || 0 >= id)
            throw new Exception("Id cannot be null or smaller than 0.");
        return billRepository.getReferenceById(id);
    }

    public Bill store(BillDto billDto) throws Exception {
        return billRepository.save(BillDtoMapper.INSTANCE.toBill(billDto));
    }

    public Bill update(Long id, BillDto billDto) throws Exception {
        Bill bill = getById(id);
        Bill billUpdated = BillDtoMapper.INSTANCE.toBill(billDto);
        billUpdated.setId(bill.getId());

        return billRepository.save(billUpdated);
    }

    public void delete(Long id) {
        billRepository.deleteById(id);
    }
}