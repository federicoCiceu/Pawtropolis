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
<<<<<<< Updated upstream:src/main/java/projectzoo/game/Player.java
=======

    }

    public int bagUsedSlots() {
      return bag.bagUsedSlots();
    }

    public  List<Item> getItems() {
        return bag.getItems();
    }

    public void addItem(Item item) {
        bag.addItem(item);
    }

    public void dropItem(Item item){
        bag.dropItem(item);
>>>>>>> Stashed changes:src/main/java/pawtropolis/game/Player.java
    }

    public String getName() {
        return namePlayer;
    }

    public Bag getBag() {
        return bag;
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
