package pawtropolis.game.model;


import lombok.Data;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.List;

@Data
public class Player {
    private String name;
    private int lifePoints;
    private Bag bag;

    public Player() {
        this.bag = new Bag(30);
    }

    public int bagUsedSlots() {
      return bag.bagUsedSlots();
    }

    public  List<Item> getItems() {
        return bag.getItems();
    }

    public void addItem(Item item) {
            bag.getItems().add(item);
    }

    public void dropItem(Item item){
        bag.dropItem(item);
    }

}


