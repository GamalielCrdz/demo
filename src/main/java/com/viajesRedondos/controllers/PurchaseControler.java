package com.viajesRedondos.controllers;

import com.viajesRedondos.models.Purchase;
import com.viajesRedondos.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class PurchaseControler {
    @Autowired
    private PurchaseRepository purchaseRepository;

    @PostMapping(path="/purchase")
    public Purchase create(@RequestBody Purchase purchase){
        return this.purchaseRepository.save(purchase);
    }

    @GetMapping(path="/purchase/{id}")
    public Purchase show(@PathVariable Long id){
        return this.purchaseRepository.findOne(id);
    }
    
}