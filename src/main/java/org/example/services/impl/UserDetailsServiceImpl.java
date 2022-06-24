package org.example.services.impl;
import org.example.Repository.UserDetailsRepository.UserDetailsRepository;
import org.example.Repository.UserDetailsRepository.impl.UserDetailsRepositoryImpl;
import org.example.model.UserDetails;
import org.example.services.UserDetailsService;

import java.util.List;
import java.util.Optional;

public class UserDetailsServiceImpl implements UserDetailsService {
    UserDetailsRepository users = new UserDetailsRepositoryImpl();
    public UserDetails save(UserDetails u){
        return users.save(u);
    }
    public Optional<UserDetails> findById(Integer id){
        return users.findById(id);
    }
    public List<UserDetails> findAll(){
        return users.findAll();
    }
    public UserDetails delete(UserDetails u){
        return users.delete(u);
    }
}
