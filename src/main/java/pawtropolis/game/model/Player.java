package pawtropolis.game.model;


import lombok.Data;


import java.util.List;

@Data
public class Player {

    private String name;
    private int lifePoints;
    private final Bag bag;

    public Player(String name, int lifePoints) {
        this.name = name;
        this.lifePoints = lifePoints;
        this.bag = new Bag(30);

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


}


