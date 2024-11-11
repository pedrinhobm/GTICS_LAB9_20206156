package com.example.clase9webservice.controller;
import com.example.clase9webservice.entity.Category;
import com.example.clase9webservice.dao.CategoryDao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    final CategoryDao categoryDao;

    public CategoryController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @GetMapping("")
    public List<Category> listar() {
        return categoryDao.findAll();
    }
}

