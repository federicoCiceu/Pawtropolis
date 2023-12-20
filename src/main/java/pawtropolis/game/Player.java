package pawtropolis.game;


import java.util.List;

public class Player {

    private String name;
    private int lifePoints;
    private final Bag bag;

    public Player(String name, int lifePoints) {
        this.name = name;
        this.lifePoints = lifePoints;
        this.bag = new Bag(30);

    }

    public Bag getBag() {
        return bag;
    }

    public int bagUsedSlots() {
      return bag.bagUsedSlots();
    }

    public List<Item> getItemList() {

        return bag.getItemList();
    }
    public void addItem(Item item) {
        bag.addItem(item);
    }

    public void dropItem(String item){
        bag.dropItem(item);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

}

