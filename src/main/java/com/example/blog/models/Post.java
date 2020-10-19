package com.example.blog.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.SimpleDateFormat;
import java.util.Date;

@Document(collection = "post")
public class Post {

    @Id
    private String id;


    private String title, full_text, author, authorImg;

    private int rate;

    private long likes = 0L;

    private String date;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public Long getLikes() {
        return likes;
    }

    public void setLikes() {
        this.likes++;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }



    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }


    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", full_text='" + full_text + '\'' +
                ", author='" + author + '\'' +
                ", authorImg='" + authorImg + '\'' +
                ", rate=" + rate +
                ", likes=" + likes +
                ", date='" + date + '\'' +
                '}';
    }

    public Post() { }


    public Post(String title, String full_text, int rate) {
        this.title = title;
        this.full_text = full_text;
        this.rate = rate;

        SimpleDateFormat dateFormat = new SimpleDateFormat("E HH:mm dd.MM.yy");
        this.date = dateFormat.format(new Date());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFull_text() {
        return full_text;
    }

    public void setFull_text(String full_text) {
        this.full_text = full_text;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getAuthorImg() {
        return authorImg;
    }

    public void setAuthorImg(String authorImg) {
        this.authorImg = authorImg;
    }


}
