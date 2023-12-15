package pawtropolis.game;

import java.util.ArrayList;
import java.util.List;


public class Bag {

    private List<Item> itemList;
    private int availableSlot;

    public Bag(int availableSlot) {
        this.itemList = new ArrayList<>();
        this.availableSlot = availableSlot;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public int bagUsedSlots() {
        return itemList.stream()
                .mapToInt(Item::getSlotRequired)
                .sum();
    }

    public void addItem(Item item) {
        if (itemList.size() < availableSlot) {
            itemList.add(item);
        } else {
            System.out.println("The bag is full. Can't add " + item.getName() + ".");
        }
    }

    public void dropItem(String itemName) {
        boolean itemFound = itemList.removeIf(item -> item.getName().equals(itemName));

        if (!itemFound) {
            System.out.println("The item '" + itemName + " is not present inside the bag.");
        }
    }

    public int getAvailableSlot() {
        return availableSlot;
    }

    public void setAvailableSlot(int availableSlot) {
        this.availableSlot = availableSlot;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

}
