package com.study.spring.service;

import com.study.spring.domain.Movie;
import com.study.spring.domain.MovieGroup;
import com.study.spring.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository)
    {
        this.movieRepository = movieRepository;
    }


    public List<Movie> search(final String query)
    {
        MovieGroup movieGroup = new MovieGroup(movieRepository.findByQuery(query));
        return movieGroup.getListOrderRating();
    }

}
