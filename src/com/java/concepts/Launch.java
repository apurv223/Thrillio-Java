package com.java.concepts;

import com.java.concepts.entity.Bookmark;
import com.java.concepts.entity.User;
import com.java.concepts.manager.BookmarkManager;
import com.java.concepts.manager.UserManager;

public class Launch {

    private static User[] users;
    private static Bookmark[][] bookmarks;

    private static void loadData() {
        System.out.println("1. Loading data...");
        DataStore.loadData();

        users = UserManager.getInstance().getUsers();
        bookmarks = BookmarkManager.getInstance().getBookmarks();

        System.out.println("2. Printing data ...");
        printUserData();
        printBookmarkData();
    }

    private static void printUserData() {
        for (User user : users) {
            System.out.println(user);
        }

    }

    private static void printBookmarkData() {
        for (Bookmark[] bookmark_group : bookmarks) {
            for (Bookmark bookmark : bookmark_group) {
                System.out.println(bookmark);
            }
        }
    }

    public static void main(String[] args) {
        loadData();
    }
}
