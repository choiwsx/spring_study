package com.study.spring.repository;

import com.study.spring.domain.Movie;

import java.util.List;

public interface MovieRepository {
    List<Movie> findByQuery(String query);
}
