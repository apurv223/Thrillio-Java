package com.java.code.entity;

public class WebLink extends Bookmark {
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
        if(this.url.toLowerCase().contains("porn") || this.getTitle().toLowerCase().contains("Porn") ||this.host.toLowerCase().contains("adult") ) return false;
        return true;
    }

    @Override
    public String toString() {
        return "WebLink{" +
                "url='" + url + '\'' +
                ", host='" + host + '\'' +
                '}';
    }
}
