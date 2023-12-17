package com.example.flight.service;// src/main/java/com/example/flightapp/service/FlightService.java

import com.example.flight.model.Flight;
import com.example.flight.model.Passenger;
import com.example.flight.repository.FlightRepository;
import com.example.flight.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public class FlightService {

    private final FlightRepository flightRepository;
    private final PassengerRepository passengerRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository, PassengerRepository passengerRepository) {
        this.flightRepository = flightRepository;
        this.passengerRepository = passengerRepository;
    }

    public Set<Passenger> getPassengersForFlight(Long flightId) {
        Flight flight = flightRepository.findById(flightId).orElse(null);
        if (flight != null) {
            return flight.getPassengers();
        }
        return null;
    }

    public void addPassengerToFlight(Long flightId, Long passengerId) {
        Flight flight = flightRepository.findById(flightId).orElse(null);
        Passenger passenger = passengerRepository.findById(passengerId).orElse(null);
        if (flight != null && passenger != null) {
            flight.getPassengers().add(passenger);
            flightRepository.save(flight);
        }
    }
}
