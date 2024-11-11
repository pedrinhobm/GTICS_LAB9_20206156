package com.example.clase9webservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category {

    private int idCategory;
    private String strCategory;
    private String strCategoryThumb;
    private String strCategoryDescription;

}

