package com.java.code.manager;

import com.java.code.dao.UserDao;
import com.java.code.entity.User;

public class UserManager {
    private static UserManager instance = new UserManager();
    private static UserDao userDao = new UserDao();
    private UserManager() {
    }

    public static UserManager getInstance() {
        return instance;
    }

    public User createUser(long id,
                           String email,
                           String password,
                           String firstName,
                           String lastName,
                           int gender,
                           String userType) {
        User user = new User();
        user.setId(id);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);
        user.setGender(gender);
        user.setUserType(userType);
        return user;
    }

    public User[] getUsers(){
        return userDao.getUsers();
    }
}
