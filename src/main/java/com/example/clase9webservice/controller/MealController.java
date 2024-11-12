package com.example.clase9webservice.controller;

import com.example.clase9webservice.entity.Meal;

import com.example.clase9webservice.dao.MealDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping()
public class MealController {
    @Autowired
    final MealDao mealDao;

    public MealController(MealDao mealDao) {
        this.mealDao = mealDao;
    }

    @GetMapping("/meals")
    public String listMeals(Model model) {
        List<Meal> meals = mealDao.listarMeals();
        model.addAttribute("meals", meals);
        return "mealList";
    }

    @GetMapping("/meal/{id}")
    public String mostrarDetalleMeal(@PathVariable int id, Model model) {
        Meal meal = mealDao.buscarPorID(id);
        if(meal != null) {
            model.addAttribute("meal", meal);
        }else{
            model.addAttribute("error", "No disponible");
        }
        return "mealDetails";
    }

    @PostMapping("/meal/favorite/add")
    @ResponseBody
    public String addFavorite(@RequestParam int idMeal){
        Meal meal = mealDao.buscarPorID(idMeal);
        if(meal != null) {
            meal.setFavorite(true);
            return "success";
        }

    }
}