package com.study.spring.domain;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;


@Builder
@Getter
public class Movie implements Serializable {

    private String title;
    private String link;
    private String image;
    private String actor;
    private float userRating;

}
