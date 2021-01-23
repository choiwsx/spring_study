package com.study.spring.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseProduct {


    private List<Item> items;
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Item{
        private LocalDateTime lastBuildDate;
        private int total;//검색 결과 문서의 총 개수
        private int start;//검색 결과 문서 중, 문서의 시작점
        private int display;//검색된 결과의 개수
        private String title;//검색 결과 문서의 제목
        private String link;
        private String image;
        private String lprice;//최저가
        private String hprice;//최고가
        private String mallName;
        private String productId;
        private int productType;
        private String maker;
        private String brand;
        private String category1;
        private String category2;
        private String category3;
        private String category4;
    }



}
