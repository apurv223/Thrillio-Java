package com.java.code.entity;

import com.java.code.partner.Shareable;
import org.junit.platform.commons.util.StringUtils;

import java.util.Arrays;

public class Book extends Bookmark implements Shareable {
    private int publicationYear;
    private String publisher;
    private String[] authors;
    private String genre;
    private double amazonRating;

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getAmazonRating() {
        return amazonRating;
    }

    public void setAmazonRating(double amazonRating) {
        this.amazonRating = amazonRating;
    }

    @Override
    public boolean isKidFriendly() {
        if(this.getTitle().toLowerCase().contains("porn")) return false;
        if(publisher.toLowerCase().contains("porn")) return false;
        if(genre.toLowerCase().contains("philosophy")) return false;
        return !genre.toLowerCase().contains("self help");
    }

    @Override
    public String toString() {
        return "Book{" +
                "publicationYear=" + publicationYear +
                ", publisher='" + publisher + '\'' +
                ", authors=" + Arrays.toString(authors) +
                ", genre='" + genre + '\'' +
                ", amazonRating=" + amazonRating +
                '}';
    }

    @Override
    public String getData() {
        return "<item>" +
                "<type>Book</type>" +
                "<title>" + getTitle() + "</title>" +
                "<publisher>" + publisher + "</publisher>" +
                "<publicationYear>" + publicationYear + "</publicationYear>" +
                "<genre>" + genre + "</genre>" +
                "<authors>" +
                Arrays.toString(authors) +
                "</authors>" +
                "<amazonRating>" + amazonRating + "</amazonRating>" +
                "</item>";
    }
}
