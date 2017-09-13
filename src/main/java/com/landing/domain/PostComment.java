package com.landing.domain;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by pipe on 9/13/17.
 */

@Document(collection = "postComment")
public class PostComment {
    private String name;
    private String message;
    private String date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
