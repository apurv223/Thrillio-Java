package com.java.test.entity;

import com.java.code.constants.MovieGenre;
import com.java.code.entity.Movie;
import com.java.code.manager.BookmarkManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    @Test
    void isKidFriendly() {
        Movie movie;
        // Test 1: "horror" in genre -- false
        movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "-", 1941,
                new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.HORROR, 8.5);
        assertFalse(movie.isKidFriendly(),"\"horror\" in movie genre, should be false");
        // Test 2: "thriller" in genre
        movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "-", 1941,
                new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.THRILLERS, 8.5);
        assertFalse(movie.isKidFriendly(),"\"thriller\" in movie genre, should be false");

    }
}