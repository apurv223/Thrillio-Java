package com.java.code.controller;

import com.java.code.entity.Bookmark;
import com.java.code.entity.User;
import com.java.code.manager.BookmarkManager;

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
