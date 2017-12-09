package com.viajesRedondos.repository;

import com.viajesRedondos.models.Purchase;

import org.springframework.data.repository.CrudRepository;

public interface PurchaseRepository extends CrudRepository<Purchase, Long> {

}