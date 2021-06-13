package com.java.code.dao;

import com.java.code.DataStore;
import com.java.code.entity.Bookmark;
import com.java.code.entity.UserBookmark;

public class BookmarkDao {
    public Bookmark[][] getBookmarks(){
        return DataStore.getBookmarks();
    }


    public void saveUserBookmark(UserBookmark userBookmark) {
        DataStore.add(userBookmark);
    }
}
