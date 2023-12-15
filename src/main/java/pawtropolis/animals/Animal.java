package pawtropolis.animals;

import java.time.LocalDate;

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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getDateEntry() {
        return dateEntry;
    }

    public void setDateEntry(LocalDate dateEntry) {
        this.dateEntry = dateEntry;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

}
