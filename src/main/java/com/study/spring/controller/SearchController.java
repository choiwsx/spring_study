package com.study.spring.controller;

import com.study.spring.domain.Movie;
import com.study.spring.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/search")
public class SearchController {


    private final MovieService movieService;

    public SearchController(MovieService movieService)
    {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public List<Movie> getMoviesByQuery(@RequestParam(name="q") String query)
    {
        return movieService.search(query);
    }
}
