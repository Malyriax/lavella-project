package com.lavella.service;

import com.lavella.repository.DishRepository;
import com.lavella.entity.Dish;
import com.lavella.entity.DishType;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DishService {
    private final DishRepository dishRepository;

    public DishService(DishRepository dishRepository) { // Конструктор
        this.dishRepository = dishRepository;
    }

    public List<Dish> getAllDishes() { // метод поиска всех записей
        return dishRepository.findAll();
    }

    public void addNewDish(Dish dish) {
        // validation
        if (dish.getName() == null || dishRepository.existsByNameIgnoreCase(dish.getName())){ // It is prohibited to create dishes with same names
            throw new IllegalArgumentException("Dish with this name already exists");
        }

        if (dish.getPrice() == null || dish.getPrice().compareTo(BigDecimal.ZERO) < 0) { // It is prohibited to put negative prices
            throw new IllegalArgumentException("Price cannot be negative or null");
        }
        dishRepository.save(dish);
    }

    public void deleteDish(Dish dish) {
        dishRepository.delete(dish);
    }

    public void deleteDishById(Long id) {
        dishRepository.deleteById(id);
    }

    public Dish getDishById(Long id) {
        return dishRepository.findById(id).orElseThrow(() -> new RuntimeException("DishNotFound"));
        // тут сложно, советую отдельно почитать про обертку Optional и как она
        // работает, в комментарий не уместить
    }

    public boolean dishExistsById(Long id) {
        return dishRepository.existsById(id);
    }

    // переключает доступность позиции. тут стоял выбор между жестким ООП и тем как
    // чаще делают. частая практика что подобные
    // методы не только переключают но еще и возвращают обновленный объект, но я
    // считаю правильнее философию один метод - одно действие
    public void toggleDishAvailability(Long id) {
        Dish dish = getDishById(id);
        dish.setAvailable(!dish.isAvailable());
        dishRepository.save(dish);
    }

    public List<Dish> getAllAvailableDishes() {
        return dishRepository.findByAvailableTrue();
    }

    public List<Dish> getDishesByType(DishType type) {
        return dishRepository.findByType(type);
    }

    public List<Dish> getDishesByTypeAvailable(DishType type) {
        return dishRepository.findByTypeAndAvailableTrue(type);
    }

    public void updateDishPrice(Long id, BigDecimal price) {
        // validation
        if (price == null || price.compareTo(BigDecimal.ZERO) < 0) { // It is prohibited to put negative prices
            throw new IllegalArgumentException("Price cannot be negative or null");
        }
        Dish dish = getDishById(id);
        dish.setPrice(price);
        dishRepository.save(dish);
    }

    public List<Dish> findDishByNameContaining(String name) {
        return dishRepository.findByNameContainingIgnoreCase(name);
    }

    public Dish findDishByName(String name) {
        return dishRepository.findByNameIgnoreCase(name)
                .orElseThrow(() -> new RuntimeException("Dish not found: " + name));
    }
}
