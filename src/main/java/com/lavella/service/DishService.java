package com.lavella.service;

import com.lavella.repository.DishRepository;
import com.lavella.entity.Dish;
import org.springframework.stereotype.Service;
import java.util.*;

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
    public void toggleDishAvailability(long id) {
        Dish dish = getDishById(id);
        dish.setAvailable(!dish.isAvailable());
        dishRepository.save(dish);
    }
    public List<Dish> getAllAvailableDishes(){
        return dishRepository.findByAvailableTrue();  
    }
    //public Dish searchDishesByName(String name){
      //  return dishRepository.findByName();
    //}

}