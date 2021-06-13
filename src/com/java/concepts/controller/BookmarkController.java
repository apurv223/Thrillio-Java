package com.java.concepts.controller;

import com.java.concepts.entity.Bookmark;
import com.java.concepts.entity.User;
import com.java.concepts.manager.BookmarkManager;

public class BookmarkController {
    private static BookmarkController instance = new BookmarkController();
    private  BookmarkController(){};

    public static BookmarkController getInstance(){
        return  instance;
    }


    public void saveUserBookmark(User user, Bookmark bookmark) {
        BookmarkManager.getInstance().saveUserBookmark(user,bookmark);
    }
}
