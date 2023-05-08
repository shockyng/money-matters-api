package com.moneymatters.controllers;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moneymatters.data.dtos.BillDto;
import com.moneymatters.data.models.Bill;
import com.moneymatters.services.BillService;

@RestController
@RequestMapping("/bills")
public class BillController {

    private final BillService billService;

    @Autowired
    public BillController(BillService billService) {
        this.billService = billService;
    }

    @GetMapping("/page")
    public Page<Bill> getAllPaged(@RequestParam(required = false) String name,
                                  @RequestParam(required = false) String description,
                                  @RequestParam(required = false) String paymentType,
                                  @RequestParam(required = false) Integer installments,
                                  @RequestParam(required = false) Date dueDate, Pageable pageable) {
        return billService.getAllPaged(name, description, paymentType, installments, dueDate, pageable);
    }

    @GetMapping("/{id}")
    public Bill getById(@PathVariable("id") Long id) throws Exception {
        return billService.getById(id);
    }

    @PostMapping
    public Bill store(@RequestBody BillDto billDto) throws Exception {
        return billService.store(billDto);
    }

    @PutMapping("/{id}")
    public Bill update(@PathVariable("id") Long id, @RequestBody BillDto billDto) throws Exception {
        return billService.update(id, billDto);
    }

}
