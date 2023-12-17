package com.example.flight.service;// src/main/java/com/example/flightapp/service/PassengerService.java

import com.example.flight.model.Flight;
import com.example.flight.model.Passenger;
import com.example.flight.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public class PassengerService {

    private final PassengerRepository passengerRepository;

    @Autowired
    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public Set<Flight> getFlightsForPassenger(Long passengerId) {
        Passenger passenger = passengerRepository.findById(passengerId).orElse(null);
        if (passenger != null) {
            return passenger.getFlights();
        }
        return null;
    }
}
