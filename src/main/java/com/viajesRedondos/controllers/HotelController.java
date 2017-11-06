package com.viajesRedondos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.viajesRedondos.models.Hotel;
import com.viajesRedondos.repository.HotelRepository;

@RestController
public class HotelController {
    @Autowired
    private HotelRepository hotelRepository;
    
    @GetMapping(path="/hotel/index")
    public Iterable<Hotel> index(){
        return hotelRepository.findAll();
    }

    @PostMapping(path="/hotel")
    public String create(@RequestBody Hotel hotel){
        this.hotelRepository.save(hotel);
        return "Saved";
    }

    @CrossOrigin
    @DeleteMapping(path = "/hotel/{id}")
    public String delete(@PathVariable Long id) {
        this.hotelRepository.delete(id);
        return "deleted";
    }
}   