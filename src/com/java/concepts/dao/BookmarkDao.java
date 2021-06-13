package com.java.concepts.dao;

import com.java.concepts.DataStore;
import com.java.concepts.entity.Bookmark;

public class BookmarkDao {
    public Bookmark[][] getBookmarks(){
        return DataStore.getBookmarks();
    }
}
