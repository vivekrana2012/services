package com.halfspace.services.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.halfspace.services.articlerepository",
        mongoTemplateRef = "articleMongoTemplate")
public class ArticleMongoConfig {
}
