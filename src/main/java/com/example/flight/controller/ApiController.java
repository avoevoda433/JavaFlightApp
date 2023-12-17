// ApiController.java
package com.example.flight.controller;

import com.example.flight.model.Flight;
import com.example.flight.model.Passenger;
import com.example.flight.repository.FlightRepository;
import com.example.flight.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final PassengerRepository passengerRepository;
    private final FlightRepository flightRepository;

    @Autowired
    public ApiController(PassengerRepository passengerRepository, FlightRepository flightRepository) {
        this.passengerRepository = passengerRepository;
        this.flightRepository = flightRepository;
    }

    @GetMapping("/passengers")
    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    @GetMapping("/passengers/{id}")
    public Passenger getPassengerById(@PathVariable Long id) {
        return passengerRepository.findById(id).orElse(null);
    }

    @PostMapping("/passengers")
    public Passenger addPassenger(@RequestBody Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    @GetMapping("/flights")
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    @GetMapping("/flights/{id}")
    public Flight getFlightById(@PathVariable Long id) {
        return flightRepository.findById(id).orElse(null);
    }

    @PostMapping("/flights")
    public Flight addFlight(@RequestBody Flight flight) {
        return flightRepository.save(flight);
    }
}
