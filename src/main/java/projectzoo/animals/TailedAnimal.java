package projectzoo.animals;

import java.time.LocalDate;

public class TailedAnimal extends Animal {
    private double tailLength;

    public TailedAnimal(String nickname, String favoriteFood, int age, LocalDate dateEntry, double weight, double height, double tailLength) {
        super(nickname, favoriteFood, age, dateEntry, weight, height);
        this.tailLength = tailLength;
    }

    public double getTailLength() {
        return tailLength;
    }

    public void setTailLength(double tailLength) {
        this.tailLength = tailLength;
    }
}
