package com.study.spring.controller;

import com.study.spring.domain.Movie;
import com.study.spring.domain.MovieGroup;
import com.study.spring.domain.Product;
import com.study.spring.service.MovieService;
import com.study.spring.service.ProductService;
import com.study.spring.task.deleteMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/search")
public class SearchController {


    private final MovieService movieService;
    private final ProductService productService;
    Map<String, MovieGroup> movieMap = new HashMap<String, MovieGroup>();
    public SearchController(MovieService movieService, ProductService productService)
    {
        this.movieService = movieService;
        this.productService = productService;
    }

    @GetMapping("/movies")
    public List<Movie> getMoviesByQuery(@RequestParam(name="q") String query)
    {
        List<Movie> movieList = new ArrayList<>();

        if(movieMap.containsKey(query)) //무비 맵에 이미 결과물이 저장되어 있는 경우.
        {
            MovieGroup movieGroup = movieMap.get(query);
            movieList = movieGroup.getList();
        }
        else //무비 맵에 해당 키가 없는 경우
        {
            movieList = movieService.search(query);  //네이버 openapi를 사용하여 리스트 가지고 오기.
            MovieGroup searchMovie = new MovieGroup(movieList);
            movieMap.put(query, searchMovie);

            Timer timer = new Timer();
            timer.schedule(new deleteMovie(query, this), 600000, 1000); //해당 결과물을 10분뒤에 삭제.

        }
        return movieList;
    }


    public void deleteMovieInMap(String query)
    {
        if(movieMap.containsKey(query))
            movieMap.remove(query);
    }




    @PostMapping("/updateMovie")
    public void updateMovieByQuery(@RequestParam(name="q") String query)
    {
        List<Movie> movieList = movieService.search(query);
        MovieGroup searchMovie = new MovieGroup(movieList);
        movieMap.put(query, searchMovie);
    }



    @GetMapping("/products")
    public List<Product> getProductsByQuery(@RequestParam(name="q") String query) { return  productService.search(query);}
}
