package com.java.code.controller;

import com.java.code.entity.Bookmark;
import com.java.code.entity.User;
import com.java.code.manager.BookmarkManager;

public class BookmarkController {
    private static BookmarkController instance = new BookmarkController();
    private  BookmarkController(){}

    public static BookmarkController getInstance(){
        return  instance;
    }


    public void saveUserBookmark(User user, Bookmark bookmark) {
        BookmarkManager.getInstance().saveUserBookmark(user,bookmark);
    }

    public void setKidFriendlyStatus(User user, String kidFriendlyDecision, Bookmark bookmark) {
        BookmarkManager.getInstance().setKidFriendlyStatus(user, kidFriendlyDecision, bookmark);
    }

    public void share(User user, Bookmark bookmark) {
        BookmarkManager.getInstance().share(user, bookmark);
    }
}
