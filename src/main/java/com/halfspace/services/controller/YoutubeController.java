package com.halfspace.services.controller;

import com.halfspace.services.model.Video;
import com.halfspace.services.service.YoutubeService;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequestMapping("/v1/video")
@RestController
public class YoutubeController {

  private YoutubeService youtubeService;
  private CacheManager cacheManager;

  public YoutubeController(YoutubeService youtubeService, CacheManager cacheManager){
    this.youtubeService = youtubeService;
    this.cacheManager = cacheManager;
  }

  @Cacheable("videos")
  @CrossOrigin
  @GetMapping("/all")
  public List<Video> getAllVideos(){

    Optional<List<Video>> videoOptional = youtubeService.getAllVideosExceptExceptions();

    return videoOptional.orElseGet(() -> new ArrayList<>(1));
  }

  @Scheduled(initialDelay = 60000*15, fixedDelay = 60000*15)
  public void clearCache(){
    cacheManager.getCacheNames().forEach(cache -> Objects.requireNonNull(cacheManager.getCache(cache)).clear());
  }
}
