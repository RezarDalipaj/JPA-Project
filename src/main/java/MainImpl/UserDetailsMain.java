package MainImpl;

import org.example.model.Flight;
import org.example.model.UserDetails;
import org.example.services.FlightService;
import org.example.services.UserDetailsService;

import java.util.*;

public class UserDetailsMain {
    public static void find(){
        UserDetailsService userDetail = new UserDetailsService();
        List<UserDetails> userDetailsList = userDetail.findAll();
        System.out.println("All the user details...\n");
        for (UserDetails ud : userDetailsList) {
            System.out.println(ud);
        }
    }
    public static void add(){
        Scanner read = new Scanner(System.in);
        UserDetailsService userDetail = new UserDetailsService();
        Integer id = 0;
        System.out.println("\nAdding user details\n");
        System.out.println("Enter user detail id");
        try {
            id = read.nextInt();
            read.nextLine();
        }catch (InputMismatchException e){
            System.out.println("Id should be a number");
            read.nextLine();
        }
        System.out.println("Enter the first name");
        String fn = read.nextLine();
        System.out.println("Enter the last name");
        String ln = read.nextLine();
        System.out.println("Enter the email");
        String email = read.nextLine();
        System.out.println("Enter the phone number");
        String phone = read.nextLine();
        Optional<UserDetails> userDetailById = userDetail.findById(id);
        if (userDetailById.isPresent()){
            UserDetails ud1 = userDetailById.get();
            ud1.setFirstName(fn);
            ud1.setLastName(ln);
            ud1.setEmail(email);
            ud1.setPhoneNumber(phone);
            userDetail.save(ud1);
        }
        else {
            UserDetails ud2 = new UserDetails();
            ud2.setId(null);
            ud2.setFirstName(fn);
            ud2.setLastName(ln);
            ud2.setEmail(email);
            ud2.setPhoneNumber(phone);
            userDetail.save(ud2);
        }
    }
    public static void findId(){
        Scanner read = new Scanner(System.in);
        UserDetailsService userDetail = new UserDetailsService();
        Integer find = 0;
        System.out.println("\nFinding user details by id\n");
        try {
            System.out.println("Enter the user details id you want to find");
            find = read.nextInt();
            read.nextLine();
        }catch (InputMismatchException e){
            read.nextLine();
            System.out.println("Id should be a number");
        }
        Optional<UserDetails> userDetails1 = userDetail.findById(find);
        if (userDetails1.isPresent()){
            UserDetails byId = userDetails1.get();
            System.out.println(byId);
        }
        else
            System.out.println("These user details dont exist");
    }
    public static void remove(){
        Integer find = 0;
        Scanner read = new Scanner(System.in);
        UserDetailsService userDetail = new UserDetailsService();
        System.out.println("\nDeleting user details\n");
        try {
            System.out.println("Enter the user details id you want to delete");
            find = read.nextInt();
            read.nextLine();
        }catch (InputMismatchException e){
            read.nextLine();
            System.out.println("Id should be a number");
        }
        Optional<UserDetails> userDetails2 = userDetail.findById(find);
        if (userDetails2.isPresent()){
            UserDetails udelete = userDetails2.get();
            userDetail.delete(udelete);
        }
        else
            System.out.println("These user details dont exist");
    }
}
