package com.halfspace.services.configuration;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "mongodb")
public class MultipleMongoProperties {

    private MongoProperties youtube = new MongoProperties();
    private MongoProperties article = new MongoProperties();

    public MultipleMongoProperties() {
    }

    public MultipleMongoProperties(MongoProperties youtube, MongoProperties article) {
        this.youtube = youtube;
        this.article = article;
    }

    public MongoProperties getYoutube() {
        return youtube;
    }

    public void setYoutube(MongoProperties youtube) {
        this.youtube = youtube;
    }

    public MongoProperties getArticle() {
        return article;
    }

    public void setArticle(MongoProperties article) {
        this.article = article;
    }
}
