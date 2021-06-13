package com.java.concepts;

import com.java.concepts.controller.BookmarkController;
import com.java.concepts.entity.Bookmark;
import com.java.concepts.entity.User;

public class View {
    public static void bookmark(User user, Bookmark[][] bookmarks){
        System.out.println( "\nUser wiht email: "+user.getEmail() + " is bookmarking");
        for(int i=0;i<DataStore.MAX_BOOKMARKS_PER_USER;i++){
            int typeOffset = (int) (Math.random() * DataStore.BOOKMARK_TYPE_NUMBER);
            int bookmarkOffset = (int) (Math.random() * DataStore.MAX_NUMBER_PER_BOOKMARK_TYPE);

            Bookmark bookmark = bookmarks[typeOffset][bookmarkOffset];

            BookmarkController.getInstance().saveUserBookmark(user, bookmark);
            System.out.println(bookmark);
        }
    }
}
