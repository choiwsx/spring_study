package com.study.spring.repository;

import com.study.spring.config.NaverProperties;
import com.study.spring.domain.Movie;
import com.study.spring.domain.ResponseMovie;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieRepositoryImpl implements MovieRepository{

    private final RestTemplate restTemplate;
    private final NaverProperties naverProperties;

    public MovieRepositoryImpl(RestTemplate restTemplate, NaverProperties naverProperties)
    {
        this.restTemplate = restTemplate;
        this.naverProperties = naverProperties;
    }

    @Override
    public List<Movie> findByQuery(String query) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Naver-Client-Id", naverProperties.getClientId());
        httpHeaders.add("X-Naver-Client-Secret", naverProperties.getClientSecret());

        String url = naverProperties.getMovieUrl() + "?query=" + query;

        return restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(httpHeaders), ResponseMovie.class)
                .getBody()
                .getItems()
                .stream()
                .map(m -> Movie.builder()
                        .lastBuildDate(m.getLastBuildDate())
                        .title(m.getTitle())
                        .link(m.getLink())
                        .image(m.getImage())
                        .pubDate(m.getPubDate())
                        .director(m.getDirector())
                        .actor(m.getActor())
                        .userRating(m.getUserRating())
                        .build())
                .collect(Collectors.toList());
    }
}
