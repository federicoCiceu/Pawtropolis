package pawtropolis.animals;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class WingedAnimal extends Animal {
    private double wingspan;

    public WingedAnimal(String nickname, String favoriteFood, int age, LocalDate dateEntry, double weight, double height, double wingspan) {
        super(nickname, favoriteFood, age, dateEntry, weight, height);
        this.wingspan = wingspan;
    }

}
