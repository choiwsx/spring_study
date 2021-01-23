package com.study.spring.domain.mock;

import com.study.spring.config.NaverProperties;
import com.study.spring.domain.Movie;
import com.study.spring.repository.MovieRepositoryImpl;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class MockMovieRepositoryImpl extends MovieRepositoryImpl {


    public MockMovieRepositoryImpl(RestTemplate restTemplate, NaverProperties naverProperties)
    {
        super(restTemplate, naverProperties);
    }

    @Override
    public List<Movie> findByQuery(final String query){
        return Arrays.asList(
                Movie.builder().title("영화1").link("http://test").userRating(9.4f).build(),
                Movie.builder().title("영화2").link("http://test").userRating(5.2f).build(),
                Movie.builder().title("영화3").link("http://test").userRating(9.1f).build()
        );
    }

}
