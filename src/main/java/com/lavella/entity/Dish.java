package com.lavella.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity //Штука чтобы создать entity
@Getter // Геттер от Lombok
@Setter // Сеттер от Lombok
@Table(name="Dish") // объявил имя для таблицы
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // чтоб АйДи генерировался сам по себе. Auto - чтобы сам разобрался как ему удобнее
    private Long id; // С большой буквы, чтобы он мог быть null. 
    @Column(name = "dish_name", nullable = false, unique = true)
    private String name;
    @Enumerated(EnumType.STRING) // так в таблице енум будет храниться в виде названий а не номеров
    @Column(nullable = false) // думаю логично что блюдо должно относиться либо к напиткам, либо к закускам, либо к основным блюдам, чтобы можно было например сортировать по типам
    private DishType type;
    @Column(name = "price", nullable = false)
    private BigDecimal price; // Если не сталкивался, BigDecimal это класс для чисел, которые используют когда необходимо без потерь считать дробную часть. Дабл нестабилен и для денег не подходит.
    private boolean available; // тут я не использовал @Column так как ничего не хочу уточнять, всё само за меня сгенерируется.
    public Dish(){ // Конструктор
    }
}
