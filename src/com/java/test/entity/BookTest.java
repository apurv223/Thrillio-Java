package com.java.test.entity;

import com.java.code.constants.BookGenre;
import com.java.code.entity.Book;
import com.java.code.manager.BookmarkManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void isKidFriendly() {
        Book book;
        // Test 1: "porn" in title -- false
        book = BookmarkManager.getInstance().createBook(4000, "porn", "-", 1854, "Wilder Publications",
                new String[] { "Henry David Thoreau" }, BookGenre.PHILOSOPHY, 4.3);
        assertFalse(book.isKidFriendly(),"\"porn\" in title, should return false");
        // Test 2: "porn" in publisher -- false
        book = BookmarkManager.getInstance().createBook(4000, "Walden", "-", 1854, "Porn Publications",
                new String[] { "Henry David Thoreau" }, BookGenre.PHILOSOPHY, 4.3);
        assertFalse(book.isKidFriendly(),"\"porn\" in publisher, should return false");
        // Test 3: "philosophy" in genre -- false
        book = BookmarkManager.getInstance().createBook(4000, "Walden", "-", 1854, "Wilder Publications",
                new String[] { "Henry David Thoreau" }, BookGenre.PHILOSOPHY, 4.3);
        assertFalse(book.isKidFriendly(),"\"Philosophy\" in genre, should return false");
        // Test 4: "Self help" in genre -- false
        book = BookmarkManager.getInstance().createBook(4000, "Walden", "-", 1854, "Wilder Publications",
                new String[] { "Henry David Thoreau" }, BookGenre.SELF_HELP, 4.3);
        assertFalse(book.isKidFriendly(),"\"self help\" in genre, should return false");
    }
}