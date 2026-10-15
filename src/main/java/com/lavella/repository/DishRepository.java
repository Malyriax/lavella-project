package com.lavella.repository;

import com.lavella.entity.Dish; // поскольку это репозиторий для Dish нам очевидно нужен сам Dish
import com.lavella.entity.DishType;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository; // а это импорт чтобы как раз сделать репозиторий

public interface DishRepository extends JpaRepository<Dish, Long> {// создание интерфейса, указываю на сущность и лонг
                                                                   // для id
    // тело пустое, так как Spring сам на лету создаст реализацию со всеми базовыми
    // методами

    List<Dish> findByAvailableTrue(); //
    // это дичь. Спрингбут может создавать методы ПО НАЗВАНИЮ
    // конкретно этот добавляет поиск всех доступных блюд.
    // под капотом он собирает из названия команды SQL запрос. у них есть четкая
    // структура

    List<Dish> findByNameContainingIgnoreCase(String name);

    Optional<Dish> findByNameIgnoreCase(String name);

    List<Dish> findByType(DishType type);

    List<Dish> findByTypeAndAvailableTrue(DishType type);

    boolean existsByNameIgnoreCase(String name);
}