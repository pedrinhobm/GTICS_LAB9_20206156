package com.example.clase9webservice.controller;
import com.example.clase9webservice.entity.Category;
import com.example.clase9webservice.dao.CategoryDao;
import com.example.clase9webservice.entity.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping()
public class CategoryController {
    @Autowired
    final CategoryDao categoryDao;

    public CategoryController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @GetMapping("/categories")
    public String listMeals(Model model) {
        List<Category> categories = categoryDao.listar();
        model.addAttribute("categories", categories);
        return "categoriesList";
    }
}

