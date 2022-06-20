package MainImpl;

import org.example.Repository.UserRepository.UserRepository;
import org.example.Repository.UserRepository.UserRepositoryImpl;
import org.example.model.Booking;
import org.example.model.Flight;
import org.example.model.User;
import org.example.services.BookingService;
import org.example.services.FlightService;
import org.example.services.UserService;

import java.awt.print.Book;
import java.sql.Date;
import java.util.*;

public class BookingMain {
    public static void find(){
        BookingService booking = new BookingService();
        List<Booking> bookingList = booking.findAll();
        System.out.println("All the bookings...\n");
        for (Booking b : bookingList) {
            System.out.println(b);
        }
    }
    public static Booking add(){
        Scanner read = new Scanner(System.in);
        BookingService booking = new BookingService();
        Integer id = 0;
        System.out.println("\nAdding booking\n");
        System.out.println("Enter the booking id");
        try {
            id = read.nextInt();
            read.nextLine();
        }catch (InputMismatchException e){
            System.out.println("Id should be a number");
            read.nextLine();
        }
        System.out.println("Enter the id of the user who booked the flight");
        int uId = read.nextInt();
        UserService user = new UserService();
        Optional<User> userById = user.findById(uId);
        System.out.println("Enter the id of the flight");
        int fId = read.nextInt();
        FlightService flight = new FlightService();
        Optional<Flight> flightById = flight.findById(fId);
        if (userById.isPresent() && flightById.isPresent()){
            User ubyId = userById.get();
            Flight fbyId = flightById.get();
            Date date = new Date(System.currentTimeMillis());
            System.out.println("Enter the status");
            String status = read.nextLine();
            Optional<Booking> bookingById = booking.findById(id);
            if (bookingById.isPresent()){
                Booking b1 = bookingById.get();
                b1.setStatus(status);
                b1.setBookingDate(date);
                b1.setUser(ubyId);
                b1.setFlight(fbyId);
                booking.save(b1);
                return b1;
            }
            else {
                Booking b2 = new Booking();
                b2.setId(null);
                b2.setStatus(status);
                b2.setBookingDate(date);
                b2.setUser(ubyId);
                b2.setFlight(fbyId);
                booking.save(b2);
                return b2;
            }
        }
        else {
            System.out.println("Couldnt add booking. Invalid data");
            return null;
        }
    }
    public static void findId(){
        Scanner read = new Scanner(System.in);
        BookingService booking = new BookingService();
        Integer find = 0;
        System.out.println("\nFinding booking by id\n");
        try {
            System.out.println("Enter the booking id you want to find");
            find = read.nextInt();
            read.nextLine();
        }catch (InputMismatchException e){
            read.nextLine();
            System.out.println("Id should be a number");
        }
        Optional<Booking> booking1 = booking.findById(find);
        if (booking1.isPresent()){
            Booking byId = booking1.get();
            System.out.println(byId);
        }
        else
            System.out.println("This booking doesnt exist");
    }
    public static void remove(){
        Integer find = 0;
        Scanner read = new Scanner(System.in);
        BookingService booking = new BookingService();
        System.out.println("\nDeleting booking\n");
        try {
            System.out.println("Enter the booking id you want to delete");
            find = read.nextInt();
            read.nextLine();
        }catch (InputMismatchException e){
            read.nextLine();
            System.out.println("Id should be a number");
        }
        Optional<Booking> booking2 = booking.findById(find);
        if (booking2.isPresent()){
            Booking bdelete = booking2.get();
            booking.delete(bdelete);
        }
        else
            System.out.println("This booking doesnt exist");
    }
}
