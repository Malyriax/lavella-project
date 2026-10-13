package com.lavella.repository;
import com.lavella.entity.Dish; // поскольку это репозиторий для Dish нам очевидно нужен сам Dish
import org.springframework.data.jpa.repository.JpaRepository; // а это импорт чтобы как раз сделать репозиторий

public interface DishRepository extends JpaRepository<Dish, Long>{ // создание интерфейса, указываю на сущность и лонг для id
}// тело пустое, так как Spring сам на лету создаст реализацию со всеми базовыми методами