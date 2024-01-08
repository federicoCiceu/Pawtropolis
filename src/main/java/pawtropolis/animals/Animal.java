package pawtropolis.animals;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Animal {
    private String nickname;
    private String favoriteFood;
    private int age;
    private LocalDate dateEntry;
    private double weight;
    private double height;

    public Animal(String nickname, String favoriteFood, int age, LocalDate dateEntry, double weight, double height) {
        this.nickname = nickname;
        this.favoriteFood = favoriteFood;
        this.age = age;
        this.dateEntry = dateEntry;
        this.weight = weight;
        this.height = height;
    }
}