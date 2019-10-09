package com.halfspace.services.configuration;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

@Configuration
@EnableConfigurationProperties(MultipleMongoProperties.class)
public class MultipleMongoConfig {

    private final MultipleMongoProperties mongoProperties;

    public MultipleMongoConfig(MultipleMongoProperties mongoProperties) {
        this.mongoProperties = mongoProperties;
    }

    @Primary
    @Bean(name = "youtubeMongoTemplate")
    public MongoTemplate youtubeMongoTemplate() throws Exception {
        return new MongoTemplate(youtubeFactory(this.mongoProperties.getYoutube()));
    }
    @Bean(name = "articleMongoTemplate")
    public MongoTemplate articleMongoTemplate() throws Exception {
        return new MongoTemplate(articleFactory(this.mongoProperties.getArticle()));
    }
    @Bean
    @Primary
    public MongoDbFactory youtubeFactory(final MongoProperties mongo) throws Exception {
        return new SimpleMongoDbFactory(new MongoClient(new MongoClientURI(mongo.getUri())),
                mongo.getDatabase());
    }
    @Bean
    public MongoDbFactory articleFactory(final MongoProperties mongo) throws Exception {
        return new SimpleMongoDbFactory(new MongoClient(new MongoClientURI(mongo.getUri())),
                mongo.getDatabase());
    }

}
