package pawtropolis.game.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class Bag {

    private List<Item> items;
    private int slot;

    public Bag(int slot) {
        this.items = new ArrayList<>();
        this.slot = slot;
    }

    public int bagUsedSlots() {
        return items.stream()
                .mapToInt(Item::getSlotRequired)
                .sum();
    }

    public void addItem(Item item) {
        if (bagUsedSlots() < slot) {
            items.add(item);
        } else {
            System.out.println("The bag is full. Can't add " + item.getName() + ".");
        }
    }

    public void dropItem(Item item) {
        items.remove(item);
    }


}
