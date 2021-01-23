package com.study.spring.domain;


import java.util.List;

public class ProductGroup {

    private final List<Product> list;

    public ProductGroup(final List<Product> list)
    {
        this.list = list;
    }

    public List<Product> getList() {return list;}

}
