package com.java.test.entity;

import com.java.code.DataStore;
import com.java.code.entity.WebLink;
import com.java.code.manager.BookmarkManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WebLinkTest {

    @Test
    void isKidFriendly() {
        WebLink link;
        // Test 1: "porn" in url -- false
        link = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger Part 2",
                "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
                "http://www.porn.com/article/2072759/core-java/taming-tiger--part-2.html", "http://www.javaworld.com");
        assertFalse(link.isKidFriendly(),"\"Porn\" is in url, should not be kid friendly");

        // Test 2: "porn" in title -- false
        link = BookmarkManager.getInstance().createWebLink(2000, "Taming Porn Part 2",
                "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
                "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html", "http://www.javaworld.com");
        assertFalse( link.isKidFriendly(),"\"Porn\" is in title, should not be kid friendly");
        // Test 3: "adult" in host -- false
        link = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger Part 2",
                "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
                "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html", "http://www.adult.com");
        assertFalse( link.isKidFriendly(),"\"Adult\" is in host, should not be kid friendly");
        // Test 4: "adult" in url, but not in host part -- true
        link = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger Part 2",
                "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
                "http://www.javaworld.com/article/2072759/core-java/taming-adult-part-2.html", "http://www.javaworld.com");
        assertTrue( link.isKidFriendly(),"\"Adult\" is in url only, should be kid friendly");
        // Test 5: "adult" in title only -- true
        link = BookmarkManager.getInstance().createWebLink(2000, "Taming Adult Part 2",
                "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
                "http://www.javaworld.com/article/2072759/core-java/taming-tiger-part-2.html", "http://www.javaworld.com");
        assertTrue( link.isKidFriendly(),"\"Adult\" is in title only, should be kid friendly");
    }
}