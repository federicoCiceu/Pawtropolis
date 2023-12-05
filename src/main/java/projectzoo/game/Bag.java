package projectzoo.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Bag {

    private List<Item> itemMap;
    private int availableSlot;

    public Bag(int availableSlot) {
        this.itemMap = new ArrayList<>();
        this.availableSlot = availableSlot;
    }

    public int bagUsedSlots() {
        int size = 0;
        for (Item item : itemMap) {
            size = item.getSlotRequired() + size;
        }
        return size;
    }


    public void viewBag() {
        for (Item item : itemMap) {
            System.out.println("- " + item.getNameItem()+" description: " + item.getDescription());
        }
    }

    public void addItem(String itemName) {
        String defaultDescription = "Default Description";
        int defaultSlotRequired = 1;
        Item item = new Item(itemName, defaultDescription, defaultSlotRequired);
        if (itemMap.size() < availableSlot) {
            itemMap.add(item);
            System.out.println(item.getNameItem() + " added to the bag.");
        } else {
            System.out.println("The bag is full. Cannot add " + item.getNameItem() + ".");
        }
    }


    public void dropItem(String itemName) {
        boolean itemFound = false;
        for (Item item : itemMap) {
            if (item.getNameItem().equals(itemName)) {
                itemFound = true;
                itemMap.remove(item);
                System.out.println("Item '" + itemName + "has been removed");
                break;
            }
        }
        if (!itemFound) {
            System.out.println("Item '" + itemName + "' not found in the bag.");
        }
    }

    public List<Item> getItemMap() {
        return itemMap;
    }

    public void setItemMap(List<Item> itemMap) {
        this.itemMap = itemMap;
    }

    public int getAvailableSlot() {
        return availableSlot;
    }

    public void setAvailableSlot(int availableSlot) {
        this.availableSlot = availableSlot;
    }


}
