package com.example.flight.controller;// src/main/java/com/example/flightapp/controller/PassengerController.java

import com.example.flight.model.Flight;
import com.example.flight.service.PassengerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {
    private final PassengerService passengerService;

    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @GetMapping("/{passengerId}/flights")
    public ResponseEntity<Set<Flight>> getFlightsForPassenger(@PathVariable Long passengerId) {
        // Реализуйте этот метод в PassengerService
        Set<Flight> flights = passengerService.getFlightsForPassenger(passengerId);
        return ResponseEntity.ok(flights);
    }

}
