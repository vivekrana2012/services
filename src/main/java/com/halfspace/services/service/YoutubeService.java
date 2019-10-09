package com.halfspace.services.service;

import com.halfspace.services.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class YoutubeService {

    private MongoTemplate mongoTemplate;

    @Autowired
    public YoutubeService(MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }

    public Optional<List<Video>> getAllVideosExceptExceptions() {

        Sort sort = Sort.by(Sort.Order.desc("published"), Sort.Order.desc("community.statistics.views"));

        PageRequest pageRequest = PageRequest.of(0, 17, sort);

        Query query = new Query(Criteria.where("channel").nin("AFC_Ajax", "FIFATV", "UEFA.tv")).with(pageRequest);

        List<Video> videos = mongoTemplate.find(query, Video.class);

        return Optional.of(videos);
    }
}
