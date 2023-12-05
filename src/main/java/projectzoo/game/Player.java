package projectzoo.game;

public class Player {

    private String namePlayer;
    private int lifePoints;


    public Player(String name, int lifePoints) {
        this.namePlayer = name;
        this.lifePoints = lifePoints;
    }

    public String getName() {
        return namePlayer;
    }

    public void setName(String name) {
        this.namePlayer = name;
    }

    public double getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }


}
