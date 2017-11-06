package com.viajesRedondos.repository;

import com.viajesRedondos.models.Travel;
import java.util.Date;
import org.springframework.data.repository.CrudRepository;

public interface TravelRepository extends CrudRepository<Travel, Long> {
    
    Iterable<Travel> findByDepartureDateAndReturnDateAndDepartureCityAndArrivalCity(
        Date departureDate, 
        Date returnDate, 
        String departureCity,
        String arrivalCity);

        Iterable<Travel> findByDepartureCityAndArrivalCity(
        String departureCity,
        String arrivalCity);
}