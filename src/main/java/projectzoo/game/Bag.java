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

    public void viewBag() {
        for (Item item : itemMap) {
            System.out.println("- " + item.getNameItem());
        }
    }

/*
    public void addItem(Item item) {
        if (item != null) {
            int requiredSlots = item.getSlotRequired();

            if (requiredSlots <= availableSlot) {
                itemMap.put(item.getNameItem(), item);
                availableSlot -= requiredSlots;
                System.out.println(item.getNameItem() + " aggiunto alla borsa. Slot disponibili rimanenti: " + availableSlot);
            } else {
                System.out.println("Impossibile aggiungere " + item.getNameItem() + " alla borsa. Slot insufficienti.");
            }
        }
    }*/

    public void addItem(String itemName, String description, int slotRequired) {
        Item item = new Item(itemName, description, slotRequired);
        itemMap.add(item);
        System.out.println(item.getNameItem() + " added to the bag.");
    }

    public void dropItem(String itemName) {
            itemMap.remove(itemName);
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
