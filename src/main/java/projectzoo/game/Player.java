package projectzoo.game;

public class Player {

    private String namePlayer;
    private int lifePoints;
<<<<<<< Updated upstream
    private Bag bag;
=======
    private final Bag bag;
    private Room currentRoom;
>>>>>>> Stashed changes

    public Player(String name, int lifePoints) {
        this.namePlayer = name;
        this.lifePoints = lifePoints;
        this.bag = new Bag(30);
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

    public Bag getBag() {
        return bag;
    }

}
