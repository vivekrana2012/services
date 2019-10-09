package com.halfspace.services.articlerepository;

import com.halfspace.services.model.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ArticleRepository extends PagingAndSortingRepository<Article, Long> {

    Optional<Page<Article>> findBySource(String source, Pageable pageRequest);
}
