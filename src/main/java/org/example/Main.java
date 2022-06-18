package org.example;

import MainImpl.BookingMain;
import MainImpl.FlightMain;
import MainImpl.UserDetailsMain;
import MainImpl.UserMain;
import org.example.model.User;
import org.example.services.UserService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String result="";
        Scanner read = new Scanner(System.in);
        while (!(result.equalsIgnoreCase("5"))){
            System.out.println("Menu User\n1.Save User\n2.Find user by id\n3.Find all users\n4.Delete a user\n5.Exit\nChoose an option (1-5)");
            result = read.nextLine();
            switch (result){
                case "1":   UserMain.add();
                            break;

                case "2":   UserMain.findId();
                            break;

                case "3":   UserMain.find();
                            break;

                case "4":   UserMain.remove();
                            break;

                case "5":   break;

                default:    System.out.println("Wrong option!");
                            break;
            }
        }
        result = "";
        while (!(result.equalsIgnoreCase("5"))){
            System.out.println("Menu User Details\n1.Save User details\n2.Find user's details by id\n3.Find all user's details\n4.Delete a user's details\n5.Exit\nChoose an option (1-5)");
            result = read.nextLine();
            switch (result){
                case "1":   UserDetailsMain.add();
                    break;

                case "2":   UserDetailsMain.findId();
                    break;

                case "3":   UserDetailsMain.find();
                    break;

                case "4":   UserDetailsMain.remove();
                    break;

                case  "5":  break;

                default:    System.out.println("Wrong option!");
                    break;

            }
        }
        result = "";
        while (!(result.equalsIgnoreCase("5"))){
            System.out.println("Menu Booking\n1.Save Booking\n2.Find booking by id\n3.Find all bookings\n4.Delete a booking\n5.Exit\nChoose an option (1-5)");
            result = read.nextLine();
            switch (result){
                case "1":   BookingMain.add();
                    break;

                case "2":   BookingMain.findId();
                    break;

                case "3":   BookingMain.find();
                    break;

                case "4":   BookingMain.remove();
                    break;

                case  "5":  break;

                default:    System.out.println("Wrong option!");
                    break;

            }
        }
        result = "";
        while (!(result.equalsIgnoreCase("5"))){
            System.out.println("Menu Flights\n1.Save Flight\n2.Find flight by id\n3.Find all flights\n4.Delete a flight\n5.Exit\nChoose an option (1-5)");
            result = read.nextLine();
            switch (result){
                case "1":   FlightMain.add();
                    break;

                case "2":   FlightMain.findId();
                    break;

                case "3":   FlightMain.find();
                    break;

                case "4":   FlightMain.remove();
                    break;

                case  "5":  break;

                default:    System.out.println("Wrong option!");
                    break;
            }
        }
    }
}
