package projectzoo.animals;

import java.time.LocalDate;

public class WingedAnimal extends Animal {
    private double wingspan;

    public WingedAnimal(String nickname, String favoriteFood, int age, LocalDate dateEntry, double weight, double height, double wingspan) {
        super(nickname, favoriteFood, age, dateEntry, weight, height);
        this.wingspan = wingspan;
    }

    public double getWingspan() {
        return wingspan;
    }

    public void setWingspan(double wingspan) {

        this.wingspan = wingspan;
    }
}
