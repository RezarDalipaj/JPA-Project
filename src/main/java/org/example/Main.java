package org.example;

import org.example.model.User;
import org.example.services.UserService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        UserService user = new UserService();
        List<User> userList = user.findAll();
        System.out.println("All the users...\n");
        for (User us : userList) {
            System.out.println(us);
        }
        Integer id = 0;
        System.out.println("\nAdding user\n");
        System.out.println("Enter the user id");
        try {
            id = read.nextInt();
            read.nextLine();
        }catch (InputMismatchException e){
            System.out.println("Id should be a number");
            read.nextLine();
        }
        System.out.println("Enter the username");
        String name = read.nextLine();
        System.out.println("Enter the user password");
        String pass = read.nextLine();
        System.out.println("Enter the user role");
        String role = read.nextLine();
        Optional<User> userById = user.findById(id);
        if (userById.isPresent()){
            User u1 = userById.get();
            u1.setUserName(name);
            u1.setRole(role);
            u1.setPassword(pass);
            user.save(u1);
        }
        else {
            User u2 = new User();
            u2.setId(null);
            u2.setUserName(name);
            u2.setRole(role);
            u2.setPassword(pass);
            user.save(u2);
        }

        Integer find = 0;
        System.out.println("\nFinding user by id\n");
        try {
            System.out.println("Enter the user id you want to find");
            find = read.nextInt();
            read.nextLine();
        }catch (InputMismatchException e){
            read.nextLine();
            System.out.println("Id should be a number");
        }
        Optional<User> user1 = user.findById(find);
        if (user1.isPresent()){
            User byId = user1.get();
            System.out.println(byId);
        }
        else
            System.out.println("This user doesnt exist");
        System.out.println("\nDeleting user\n");
        try {
            System.out.println("Enter the user id you want to delete");
            find = read.nextInt();
            read.nextLine();
        }catch (InputMismatchException e){
            read.nextLine();
            System.out.println("Id should be a number");
        }
        Optional<User> user2 = user.findById(find);
        if (user2.isPresent()){
            User udelete = user2.get();
            user.delete(udelete);
        }
        else
            System.out.println("This user doesnt exist");
        System.out.println("All the users...\n");
        userList = user.findAll();
        for (User us : userList) {
            System.out.println(us);
        }
    }
}
