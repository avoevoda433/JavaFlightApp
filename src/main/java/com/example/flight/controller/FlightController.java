package com.example.flight.controller;// src/main/java/com/example/flightapp/controller/FlightController.java

import com.example.flight.model.Passenger;
import com.example.flight.service.FlightService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
@RequestMapping("/api/flights")
public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/{flightId}/passengers")
    public ResponseEntity<Set<Passenger>> getPassengersForFlight(@PathVariable Long flightId) {
        Set<Passenger> passengers = flightService.getPassengersForFlight(flightId);
        return ResponseEntity.ok(passengers);
    }

    @PostMapping("/{flightId}/addPassenger/{passengerId}")
    public ResponseEntity<Void> addPassengerToFlight(
            @PathVariable Long flightId,
            @PathVariable Long passengerId) {
        flightService.addPassengerToFlight(flightId, passengerId);
        return ResponseEntity.ok().build();
    }

}
