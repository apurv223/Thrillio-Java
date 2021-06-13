package com.java.concepts.dao;

import com.java.concepts.DataStore;
import com.java.concepts.entity.Bookmark;
import com.java.concepts.entity.User;
import com.java.concepts.entity.UserBookmark;

public class BookmarkDao {
    public Bookmark[][] getBookmarks(){
        return DataStore.getBookmarks();
    }


    public void saveUserBookmark(UserBookmark userBookmark) {
        DataStore.add(userBookmark);
    }
}
