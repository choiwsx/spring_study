package com.study.spring.domain;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;


@Builder
@Getter
public class Movie implements Serializable {


    private LocalDateTime lastBuildDate;
    private String title;
    private String link;
    private String image;
    private String pubDate;
    private String director;
    private String actor;
    private float userRating;

}
