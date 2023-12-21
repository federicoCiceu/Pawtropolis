package pawtropolis.game;

import java.util.ArrayList;
import java.util.List;


public class Bag {

    private List<Item> items;
    private int availableSlot;

    public Bag(int availableSlot) {
        this.items = new ArrayList<>();
        this.availableSlot = availableSlot;
    }

    public List<Item> getItems() {
        return items;
    }

    public int bagUsedSlots() {
        return items.stream()
                .mapToInt(Item::getSlotRequired)
                .sum();
    }

    public void addItem(Item item) {
        if (bagUsedSlots() < availableSlot) {
            items.add(item);
        } else {
            System.out.println("The bag is full. Can't add " + item.getName() + ".");
        }
    }

    public void dropItem(Item item) {
        items.remove(item);
    }

    public int getAvailableSlot() {
        return availableSlot;
    }

    public void setAvailableSlot(int availableSlot) {
        this.availableSlot = availableSlot;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}
