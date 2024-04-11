package br.well.cardapio.controller;

import br.well.cardapio.food.Food;
import br.well.cardapio.repositories.FoodRepository;
import br.well.cardapio.food.FoodRequestDTO;
import br.well.cardapio.food.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {
    @Autowired
    private FoodRepository repository;



    @GetMapping
    public List<FoodResponseDTO> getAll(){
        List<FoodResponseDTO> foodList =  repository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;
    }

    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data){
        Food foodData = new Food(data);
        repository.save(foodData);
    }
}
