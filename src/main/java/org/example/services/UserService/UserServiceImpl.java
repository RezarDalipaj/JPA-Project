package org.example.services.UserService;

import org.example.Repository.UserRepository.UserRepository;
import org.example.Repository.UserRepository.UserRepositoryImpl;
import org.example.model.User;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService{
    UserRepository users = new UserRepositoryImpl();
    public User save(User u){
        return users.save(u);
    }
    public Optional<User> findById(Integer id){
        return users.findById(id);
    }
    public List<User> findAll(){
        return users.findAll();
    }
    public User delete(User u){
        return users.delete(u);
    }
    public Optional<User> findByUsername(String uname){
        return users.findByUsername(uname);
    }
}
