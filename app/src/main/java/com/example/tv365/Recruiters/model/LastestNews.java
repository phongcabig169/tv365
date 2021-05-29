package com.example.tv365.Recruiters.model;

public class LastestNews {
    private String imgPosterNews;
    private String Title;
    private String Content;
    private String Author;
    private String DateSubmit;

    public LastestNews() {
    }

    public LastestNews(String imgPosterNews, String title, String content, String author, String dateSubmit) {
        this.imgPosterNews = imgPosterNews;
        Title = title;
        Content = content;
        Author = author;
        DateSubmit = dateSubmit;
    }

    public String getImgPosterNews() {
        return imgPosterNews;
    }

    public void setImgPosterNews(String imgPosterNews) {
        this.imgPosterNews = imgPosterNews;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getDateSubmit() {
        return DateSubmit;
    }

    public void setDateSubmit(String dateSubmit) {
        DateSubmit = dateSubmit;
    }
}
