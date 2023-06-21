package com.moneymatters.controllers;

import com.moneymatters.data.dtos.SaleDto;
import com.moneymatters.data.models.Sale;
import com.moneymatters.services.SaleService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sales")
public class SaleController {

    private final SaleService saleService;

    @Autowired
    SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping("/page")
    public Page<Sale> getAllPaged(Pageable pageable) {
        return saleService.getAllPaged(pageable);
    }

    @GetMapping("/page/today-sales")
    public Double getTodaySales() {
        return saleService.getTodaySales();
    }

    @GetMapping("/{id}")
    public Sale getById(@PathVariable("id") Long id) {
        return saleService.getById(id);
    }

    @GetMapping("/sale-comparison-month-over-month")
    public Integer getSalesComparedToPastMonth() {
        return saleService.getSalesComparedToPastMonth();
    }

    @PostMapping
    public Sale store(@Valid @RequestBody SaleDto saleDto) {
        return saleService.store(saleDto);
    }

    @PutMapping("/{id}")
    public Sale update(@PathVariable("id") Long id, @RequestParam Boolean status) {
        return saleService.update(status, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        saleService.delete(id);
        return new ResponseEntity<>(HttpStatus.valueOf(204));
    }
}