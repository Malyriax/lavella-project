package com.lavella.entity;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity//Штука чтобы создать entity
@Table(name="MENU")//Штука чтобы создать таблицу с определнным именем
@Getter //Штука чтобы создать геттеры от lombok
@Setter//Штука чтобы создать сеттеры от lombok
public class Menu {
     @Id //Штука чтобы создать первичный ключ(primary key) если не понял читай статью 
     @GeneratedValue(strategy = GenerationType.AUTO) 
     private Long id;
     @Column(name="MENU_NAME", nullable=false, unique=true) //Штука чтобы создать колонку с определнным именем и уникальным значением
     private String name;
     @Column(name="DATE", nullable=false)
     private LocalDate  date;
     public Menu() {
     }
     
}
