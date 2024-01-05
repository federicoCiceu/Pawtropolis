package pawtropolis.game.model;


import pawtropolis.game.model.Bag;
import pawtropolis.game.model.Item;

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

    public  List<Item> getItems() {
        return bag.getItems();
    }

    public void addItem(Item item) {
        bag.addItem(item);
    }

    public void dropItem(Item item){
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


