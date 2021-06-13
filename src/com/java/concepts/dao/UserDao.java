package com.java.concepts.dao;

import com.java.concepts.DataStore;
import com.java.concepts.entity.User;

public class UserDao {
    public User[] getUsers(){
        return DataStore.getUsers();
    }
}
