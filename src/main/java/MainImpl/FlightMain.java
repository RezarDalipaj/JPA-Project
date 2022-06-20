package MainImpl;

import org.example.model.Booking;
import org.example.model.Flight;
import org.example.model.User;
import org.example.services.BookingService;
import org.example.services.FlightService;

import javax.persistence.TypedQuery;
import java.util.*;

public class FlightMain {
    public static void find(){
        FlightService flight = new FlightService();
        List<Flight> flightList = flight.findAll();
        System.out.println("All the flights...\n");
        for (Flight f : flightList) {
            System.out.println(f);
        }
    }
    public static void add(){
        Scanner read = new Scanner(System.in);
        FlightService flight = new FlightService();
        Integer id = 0;
        System.out.println("\nAdding flight\n");
        System.out.println("Enter the flight id");
        try {
            id = read.nextInt();
            read.nextLine();
        }catch (InputMismatchException e){
            System.out.println("Id should be a number");
            read.nextLine();
        }
//        List<User> users = flight.allUsers(id);
        System.out.println("Enter the origin");
        String origin = read.nextLine();
        System.out.println("Enter the destination");
        String dest = read.nextLine();
        System.out.println("Enter the airline");
        String air = read.nextLine();
        Optional<Flight> flightById = flight.findById(id);
        if (flightById.isPresent()){
            Flight f1 = flightById.get();
            f1.setOrigin(origin);
            f1.setDestination(dest);
            f1.setAirline(air);
//            f1.setUsers(users);
            flight.save(f1);
        }
        else {
            Flight f2 = new Flight();
            f2.setId(null);
            f2.setOrigin(origin);
            f2.setDestination(dest);
            f2.setAirline(air);
//            f2.setUsers(users);
            flight.save(f2);
        }
    }
    public static void findId(){
        Scanner read = new Scanner(System.in);
        FlightService flight = new FlightService();
        Integer find = 0;
        System.out.println("\nFinding flight by id\n");
        try {
            System.out.println("Enter the flight id you want to find");
            find = read.nextInt();
            read.nextLine();
        }catch (InputMismatchException e){
            read.nextLine();
            System.out.println("Id should be a number");
        }
        Optional<Flight> flight1 = flight.findById(find);
        if (flight1.isPresent()){
            Flight byId = flight1.get();
            System.out.println(byId);
        }
        else
            System.out.println("This flight doesnt exist");
    }
    public static void remove(){
        Integer find = 0;
        Scanner read = new Scanner(System.in);
        FlightService flight = new FlightService();
        System.out.println("\nDeleting flight\n");
        try {
            System.out.println("Enter the flight id you want to delete");
            find = read.nextInt();
            read.nextLine();
        }catch (InputMismatchException e){
            read.nextLine();
            System.out.println("Id should be a number");
        }
        Optional<Flight> flight2 = flight.findById(find);
        if (flight2.isPresent()){
            Flight fdelete = flight2.get();
            flight.delete(fdelete);
        }
        else
            System.out.println("This flight doesnt exist");
    }
}
