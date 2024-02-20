package com.spring.service.news.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int newsId;

    private String newsName;

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getNewsName() {
        return newsName;
    }

    public void setNewsName(String newsName) {
        this.newsName = newsName;
    }

    @Override
    public String toString() {
        return "News [newsId=" + newsId + ", newsName=" + newsName + "]";
    }

    public News() {
        super();
    }

    public News(int newsId, String newsName) {
        super();
        this.newsId = newsId;
        this.newsName = newsName;
    }
}
