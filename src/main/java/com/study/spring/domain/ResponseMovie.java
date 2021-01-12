package com.study.spring.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMovie {

    private List<Item> items;

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Item{
        private String title;
        private String link;
        private String image;
        private String actor;
        private String director;
        private float userRating;
    }
}
