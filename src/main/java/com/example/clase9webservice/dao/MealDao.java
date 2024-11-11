package com.example.clase9webservice.dao;
import com.example.clase9webservice.entity.Category;
import com.example.clase9webservice.entity.Meal;
import com.example.clase9webservice.entity.MealResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class MealDao {

    public List<Meal> listarMeals() {
        List<Meal> lista = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();

        String endPoint = "http://localhost:8080/category";

        ResponseEntity<MealResponse> responseEntity = restTemplate.getForEntity(endPoint, MealResponse.class);

        if(responseEntity.getStatusCode().is2xxSuccessful()){
            MealResponse body = responseEntity.getBody();
            lista = responseEntity.getBody().getMeals();
        }

        return lista;
    }

    public List<Category> listarCategorias() {
        List<Category> lista = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();

        String endPoint = "http://localhost:8080/category";

        ResponseEntity<Category[]> responseEntity = restTemplate.getForEntity(endPoint, Category[].class);

        if(responseEntity.getStatusCode().is2xxSuccessful()){
            Category[] body = responseEntity.getBody();
            lista = Arrays.asList(body);
        }

        return lista;
    }

    public Meal buscarPorID(int id){
        String endPoint = "http://localhost:8080/category/" + id;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<MealResponse> responseEntity = restTemplate.getForEntity(endPoint, MealResponse.class);

        if(responseEntity.getStatusCode().is2xxSuccessful() && responseEntity.getBody() != null && !responseEntity.getBody().getMeals().isEmpty()){
            return responseEntity.getBody().getMeals().get(0);
        }

        return null;
    }
}