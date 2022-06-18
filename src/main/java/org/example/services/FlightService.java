package org.example.services;
import org.example.Repository.FlightRepository.FlightRepository;
import org.example.Repository.FlightRepository.FlightRepositoryImpl;
import org.example.Repository.UserRepository.UserRepository;
import org.example.Repository.UserRepository.UserRepositoryImpl;
import org.example.model.Flight;
import org.example.model.User;

import java.util.List;
import java.util.Optional;
public class FlightService {
    FlightRepository flights = new FlightRepositoryImpl();
    public Flight save(Flight f){
        return flights.save(f);
    }
    public Optional<Flight> findById(Integer id){
        return flights.findById(id);
    }
    public List<Flight> findAll(){
        return flights.findAll();
    }
    public Flight delete(Flight f){
        return flights.delete(f);
    }
}
