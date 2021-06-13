package com.java.code.dao;

import com.java.code.DataStore;
import com.java.code.entity.User;

public class UserDao {
    public User[] getUsers(){
        return DataStore.getUsers();
    }
}
