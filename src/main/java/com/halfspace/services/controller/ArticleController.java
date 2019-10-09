package com.halfspace.services.controller;

import com.halfspace.services.model.Article;
import com.halfspace.services.service.ArticleService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/v1/article")
public class ArticleController {

    private ArticleService articleService;

    public ArticleController(ArticleService articleService){
        this.articleService = articleService;
    }

    @Cacheable("articles")
    @CrossOrigin
    @GetMapping("/all")
    public List<Article> getAllArticles(){

        return articleService.getAllArticles();
    }
}
