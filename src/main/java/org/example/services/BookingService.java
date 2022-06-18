package org.example.services;

import org.example.Repository.BookingRepository.BookingRepository;
import org.example.Repository.BookingRepository.BookingRepositoryImpl;
import org.example.model.Booking;

import java.util.List;
import java.util.Optional;

public class BookingService {
    BookingRepository bookings = new BookingRepositoryImpl();
    public Booking save(Booking b){
        return bookings.save(b);
    }
    public Optional<Booking> findById(Integer id){
        return bookings.findById(id);
    }
    public List<Booking> findAll(){
        return bookings.findAll();
    }
    public Booking delete(Booking u){
        return bookings.delete(u);
    }
}
