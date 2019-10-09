package com.halfspace.services.service;

import com.halfspace.services.articlerepository.ArticleRepository;
import com.halfspace.services.model.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    private ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }

    public List<Article> getAllArticles(){

        Sort sort = Sort.by(Sort.Order.desc("time"));

        PageRequest pageRequest = PageRequest.of(0, 24, sort);

        Optional<Page<Article>> articlePageOptional = articleRepository.findBySource("marca.com", pageRequest);

        return articlePageOptional.map(articles -> articles.get().collect(Collectors.toList()))
                .orElseGet(() -> new ArrayList<>(1));
    }
}
