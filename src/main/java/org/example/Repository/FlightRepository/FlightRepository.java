package org.example.Repository.FlightRepository;

import org.example.model.Flight;
import java.util.List;
import java.util.Optional;

public interface FlightRepository {
    public Flight save(Flight f);
    public Optional<Flight> findById(Integer id);
    public List<Flight> findAll();
    public Flight delete(Flight f);
}
