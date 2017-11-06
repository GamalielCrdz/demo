package com.viajesRedondos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.viajesRedondos.models.Travel;
import com.viajesRedondos.repository.TravelRepository;

@RestController
public class TravelController {
    @Autowired
    private TravelRepository travelRepository;

    @GetMapping(path = "/travel/index")
    public Iterable<Travel> index() {
        return travelRepository.findAll();
    }

    @PostMapping(path = "/travel")
    public String create(@RequestBody Travel travel) {
        this.travelRepository.save(travel);
        return "Saved";
    }

    @CrossOrigin
    @DeleteMapping(path = "/travel/{id}")
    public String delete(@PathVariable Long id) {
        this.travelRepository.delete(id);
        return "borrado";
    }

    @PostMapping(path = "/travel/search")
    public Iterable<Travel> search(@RequestBody Travel travel) {
        
        if (travel.getDepartureDate() == null || travel.getReturnDate() == null ) {
          return this.travelRepository.findByDepartureCityAndArrivalCity(
            travel.getDepartureCity(), 
            travel.getArrivalCity());
        }

        return this.travelRepository.findByDepartureDateAndReturnDateAndDepartureCityAndArrivalCity(
            travel.getDepartureDate(),
            travel.getReturnDate(),
            travel.getDepartureCity(),
            travel.getArrivalCity()
        );
    }
}