package com.study.spring.controller;

import com.study.spring.domain.Movie;
import com.study.spring.domain.Product;
import com.study.spring.service.MovieService;
import com.study.spring.service.ProductService;
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
    private final ProductService productService;

    public SearchController(MovieService movieService, ProductService productService)
    {
        this.movieService = movieService;
        this.productService = productService;
    }

    @GetMapping("/movies")
    public List<Movie> getMoviesByQuery(@RequestParam(name="q") String query)
    {
        return movieService.search(query);
    }

    @GetMapping("/products")
    public List<Product> getProductsByQuery(@RequestParam(name="q") String query) { return  productService.search(query);}
}
