package com.example.bff.service;

import com.example.bff.model.User;
import com.example.bff.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserBeagleService {

    List<User> us = UserRepository.getList();

    public User findUser(String username){
        User user = null;
        for(int i = 0; i < us.size(); i++){
            if (us.get(i).getUsername().equals(username)){
                user = us.get(i);
            }
        }
        return user;
    }

    public void addUser(String nome, String sobrenome, String email, String telefone){
        User newUser = new User(nome, sobrenome, email, telefone);
        us.add(newUser);
    }

    public boolean loginUser(String username, String password){
        boolean isOk = false;
        User user = findUser(username);
        if (user.getUsername().equals(username) && user.getPassword().equals(password)){
            isOk = true;
        }
        return isOk;
    }

    public void createPassword(String username, String password, String repeatPassword) {
        for (int i = 0; i < us.size(); i++) {
            if (us.get(i).getUsername().equals(username)) {
                if (password.equals(repeatPassword)) {
                    us.get(i).setPassword(password);
                }
            }
        }
    }
}
