package com.flowercolor.shop.services;

import com.flowercolor.shop.entities.User;
import com.flowercolor.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void create(User userDto) {
        User user = new User(userDto.getName(), userDto.getEmail(), userDto.getCep(), userDto.getCpf(), userDto.getPassword());
        this.repository.save(user);
    }

    public List<User> list() {
        return this.repository.findAll();
    }

    public User findById(Long id) {
        return this.repository.findById(id).get();
    }

    public User update(Long id, User userDto) {
        User user = this.findById(id);
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setCep(userDto.getCep());
        user.setCpf(userDto.getCpf());
        user.setPassword(userDto.getPassword());
        this.repository.save(user);
        System.out.println("teste");
        return user;
    }

    public void deleteById(Long id){
        this.repository.deleteById(id);
    }

}

