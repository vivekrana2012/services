package com.halfspace.services.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

@Document(collection="videos")
public class Video implements Serializable {

    @Id
    private String id;
    private String title;
    private String author;
    private String description;
    private Community community;
    private String published;
    private String updated;
    private String thumbnail;
    private String channel;

    public Video(String id, String title, String author, String description, Community community, String published
            , String updated, String thumbnail, String channel) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.community = community;
        this.published = published;
        this.updated = updated;
        this.thumbnail = thumbnail;
        this.channel = channel;
    }

    public Video() {}

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }
}
