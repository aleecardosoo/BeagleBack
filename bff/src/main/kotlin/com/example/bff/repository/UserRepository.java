package com.example.bff.repository;

import com.example.bff.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private static List<User> us = new ArrayList<User>();

    public static List getList() {
        User firstUser = new User("Alexandre", "Cardoso", "acardoso2010@outlook.com", "34992094940");
        firstUser.setUsername("aleecardosoo");
        firstUser.setPassword("ale");
        us.add(firstUser);
        return us;
    }
}
