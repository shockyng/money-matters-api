package com.moneymatters.services;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<Bill> getAllPaged(String name, String description, String paymentType, Integer installments,
            Date dueDate, Pageable pageable) {

        if (name != null && !name.isEmpty()) {
            return getAllByNamePaged(name, pageable);
        } else if (description != null && !description.isEmpty()) {
            return getAllByDescriptionPaged(description, pageable);
        } else if (paymentType != null && !paymentType.isEmpty()) {
            return getAllByPaymentTypePaged(paymentType, pageable);
        } else if (installments != null && installments >= 0) {
            return getAllByInstallmentsPaged(installments, pageable);
        } else if (dueDate != null) {
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
        if (null == id || 0 <= id)
            throw new Exception("Id cannot be null or smaller than 0.");
        return billRepository.getReferenceById(id);
    }

    public Bill store(BillDto billDto) throws Exception {
        return billRepository.save(dtoToBill(new Bill(), billDto));
    }

    public Bill update(Long id, BillDto billDto) throws Exception {
        return billRepository.save(dtoToBill(getById(id), billDto));
    }

    Bill dtoToBill(Bill bill, BillDto billDto) throws Exception {

        isValid(billDto);

        bill.setDescription(billDto.getDescription());
        Date date = Date.valueOf(billDto.getDueDate());
        bill.setDueDate(date);
        bill.setInstallments(billDto.getInstallments());
        bill.setName(billDto.getName());
        bill.setPaymentType(billDto.getPaymentType());
        bill.setPrice(billDto.getPrice());

        return bill;
    }

    public void isValid(BillDto billDto) throws Exception {
        if (null == billDto.getPrice() || 0 > billDto.getPrice()) {
            throw new Exception("Price cannot be null and must be greater than 0.");
        } else if (null == billDto.getName() || billDto.getName().trim().isEmpty()) {
            throw new Exception("The name cannot be null or empty.");
        } else if (null == billDto.getDescription() || billDto.getDescription().trim().isEmpty()) {
            throw new Exception("Description cannot be null or empty.");
        } else if (null == billDto.getPaymentType() || billDto.getPaymentType().trim().isEmpty()) {
            throw new Exception("Payment type cannot be null or empty.");
        } else if (null == billDto.getInstallments() || 0 > billDto.getInstallments()) {
            throw new Exception("Instalments cannot be null and must be greater than 0.");
        } else if (null == billDto.getDueDate() || billDto.getDueDate().trim().isEmpty()) {
            throw new Exception("Due date cannot be null or empty.");
        }
    }

}
