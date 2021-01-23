package com.study.spring.repository;


import com.study.spring.config.NaverProperties;
import com.study.spring.domain.Product;
import com.study.spring.domain.ResponseProduct;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductRepositoryImpl implements ProductRepository {

    private final RestTemplate restTemplate;
    private final NaverProperties naverProperties;

    public ProductRepositoryImpl(RestTemplate restTemplate, NaverProperties naverProperties)
    {
        this.restTemplate = restTemplate;
        this.naverProperties = naverProperties;
    }

    @Override
    public List<Product> findByQuery(String query) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Naver-Client-Id", naverProperties.getClientId());
        httpHeaders.add("X-Naver-Client-Secret", naverProperties.getClientSecret());

        String url = naverProperties.getProductUrl() + "?query=" + query;

        return restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(httpHeaders), ResponseProduct.class)
                .getBody()
                .getItems()
                .stream()
                .map(m -> Product.builder()
                        .lastBuildDate(m.getLastBuildDate())
                        .total(m.getTotal())
                        .start(m.getStart())
                        .display(m.getDisplay())
                        .title(m.getTitle())
                        .link(m.getLink())
                        .image(m.getImage())
                        .lprice(m.getLprice())
                        .hprice(m.getHprice())
                        .mallName(m.getMallName())
                        .productId(m.getProductId())
                        .productType(m.getProductType())
                        .maker(m.getMaker())
                        .brand(m.getBrand())
                        .category1(m.getCategory1())
                        .category2(m.getCategory2())
                        .category3(m.getCategory3())
                        .category4(m.getCategory4())
                        .build())
                .collect(Collectors.toList());

    }




}
