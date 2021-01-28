package com.study.spring.service;

import com.study.spring.domain.Movie;
import com.study.spring.domain.mock.MockMovieRepositoryImpl;
import com.study.spring.repository.MovieRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;



    @Test
    @DisplayName("ORDER")
    void shouldSortedInOrderOfGrade(){

        String query = "테스트쿼리";
        String expectedTopRankingMovieTile = "영화1";
        MovieRepository movieRepository = new MockMovieRepositoryImpl(null, null);
        MovieService movieService = new MovieService(movieRepository);

        List<Movie> actualMovies = movieService.search(query);

        assertEquals(expectedTopRankingMovieTile, actualMovies.stream().findFirst().get().getTitle());
    }


    @Test
    @DisplayName("평점 순으로 정렬되는지")
    void shouldSortedInOrderOfGrade_02(){

        String query = "테스트쿼리";
        String expectedTopRankingMovieTile = "영화1";
        given(movieRepository.findByQuery(anyString())).willReturn(getStubMovies());
        MovieService movieService = new MovieService(movieRepository);

        List<Movie> actualMovies = movieService.search(query);

        assertEquals(expectedTopRankingMovieTile, actualMovies.stream().findFirst().get().getTitle());
    }
    List<Movie> getStubMovies(){
        return Arrays.asList(
                Movie.builder().title("영화1").link("http://test").userRating(9.4f).build(),
                Movie.builder().title("영화2").link("http://test").userRating(5.2f).build(),
                Movie.builder().title("영화3").link("http://test").userRating(9.1f).build()
        );
    }

}