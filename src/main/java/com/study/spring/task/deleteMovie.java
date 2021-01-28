package com.study.spring.task;

import com.study.spring.controller.SearchController;
import com.study.spring.domain.MovieGroup;

import java.util.Map;
import java.util.TimerTask;

public class deleteMovie extends TimerTask {

    private final String query;
    private final SearchController searchController;

    public deleteMovie(String query, SearchController searchController)
    {
        this.query = query;
        this.searchController = searchController;
    }

    @Override
    public void run() {
        this.searchController.deleteMovieInMap(this.query);
        cancel();
    }
}
