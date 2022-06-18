package MainImpl;

import org.example.model.Booking;
import org.example.model.User;
import org.example.services.BookingService;
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
    public static void add(){
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
        Date date = new Date(System.currentTimeMillis());
        System.out.println("Enter the status");
        String status = read.nextLine();
        Optional<Booking> bookingById = booking.findById(id);
        if (bookingById.isPresent()){
            Booking b1 = bookingById.get();
            b1.setStatus(status);
            b1.setBookingDate(date);
            booking.save(b1);
        }
        else {
            Booking b2 = new Booking();
            b2.setId(null);
            b2.setStatus(status);
            b2.setBookingDate(date);
            booking.save(b2);
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
