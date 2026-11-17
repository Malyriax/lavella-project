package com.lavella.controller;

import com.lavella.entity.Dish;
import com.lavella.entity.DishType;
import com.lavella.repository.DishRepository;
import com.lavella.service.DishService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/dishes")
public class DishController {

    private final DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    // all GetMapping
    @GetMapping
    public List<Dish> getAllDishes() {
        return dishService.getAllDishes();
    }

    @GetMapping("/{id}")
    public Dish getDishById(@PathVariable Long id) {
        return dishService.getDishById(id);
    }
    @GetMapping("/available")
    public List<Dish> getAllAvailableDishes() {
        return dishService.getAllAvailableDishes();
    }

    @GetMapping("/by-type")
    public List<Dish> getAllDishesByType(@RequestParam DishType type) {
        return dishService.getDishesByType(type);
    }
    @GetMapping("/available-by-type")
        public List<Dish> getAllAvailableDishesByType(@RequestParam DishType type) {
        return dishService.getDishesByTypeAvailable(type);
    }

    // all PostMapping
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewDish(@RequestBody Dish dish) {
        dishService.addNewDish(dish);
    }
    // all DeleteMapping
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDishById(@PathVariable Long id) {
        dishService.deleteDishById(id);
    }

    // all PatchMapping
    @PatchMapping("/{id}/availability")
    public void toggleAvailability(@PathVariable Long id) {
        dishService.toggleDishAvailability(id);
    }

    @PatchMapping("/{id}/price")
    public void setPrice(@RequestBody BigDecimal newPrice, @PathVariable Long id) {
        dishService.updateDishPrice(id, newPrice);
    }
    
}  