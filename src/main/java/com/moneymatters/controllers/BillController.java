package com.moneymatters.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moneymatters.dtos.BillDto;
import com.moneymatters.models.Bill;
import com.moneymatters.services.BillService;


@RestController
@RequestMapping("/bills")
public class BillController {

    private final BillService billService;

    @Autowired
    public BillController(BillService billService){
        this.billService = billService;
    }

    @GetMapping
    public ArrayList<Bill> getAll() {
        return (ArrayList<Bill>) billService.getAll();
    }

    @GetMapping("/{id}")
    public Bill getById(@PathVariable("id") Long id) {
        return billService.getById(id);
    }

    @PostMapping
    public Bill store(@RequestBody BillDto billDto) {
        return billService.store(billDto);
    }

    @PutMapping("/{id}")
    public Bill update(@PathVariable("id") Long id, @RequestBody BillDto billDto) {
        return billService.update(id, billDto);
    }

    
}
