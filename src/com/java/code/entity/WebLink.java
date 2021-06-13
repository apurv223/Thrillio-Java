package com.java.code.entity;

import com.java.code.partner.Shareable;

public class WebLink extends Bookmark implements Shareable {
    private String url;
    private String host;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    @Override
    public boolean isKidFriendly() {
        return !this.url.toLowerCase().contains("porn") && !this.getTitle().toLowerCase().contains("porn") && !this.host.toLowerCase().contains("adult");
    }

    @Override
    public String toString() {
        return "WebLink{" +
                "url='" + url + '\'' +
                ", host='" + host + '\'' +
                '}';
    }

    @Override
    public String getData() {

        return "<item>" +
                "<type>WebLink</type>" +
                "<title>" + getTitle() + "</title>" +
                "<url>" + url + "</url>" +
                "<host>" + host + "</host>" +
                "</item>";
    }
}
