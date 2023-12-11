package projectzoo.game;

import java.util.ArrayList;
import java.util.List;


public class Bag {

    private List<Item> itemList;
    private int availableSlot;

    public Bag(int availableSlot) {
        this.itemList = new ArrayList<>();
        this.availableSlot = availableSlot;
    }

    public int bagUsedSlots() {
        int size = 0;
        for (Item item : itemList) {
            size = item.getSlotRequired() + size;
        }
        return size;
    }

    public void viewBag() {
        if (bagUsedSlots() != 0){
            for (Item item : itemList) {
            System.out.println(" " + item.getNameItem()+" description: " + item.getDescription());
        }
        }else {
            System.out.println("No items found in he bag");
        }
    }

    public void addItem(Item item) {
        if (itemList.size() < availableSlot) {
            itemList.add(item);
            System.out.println(item.getNameItem() + " added to the bag.");
        } else {
            System.out.println("The bag is full. Cannot add " + item.getNameItem() + ".");
        }
    }


    public void dropItem(String itemName) {
        boolean itemFound = false;
        for (Item item : itemList) {
            if (item.getNameItem().equals(itemName)) {
                itemFound = true;
                itemList.remove(item);
                System.out.println("Item '" + itemName + "has been removed");
                break;
            }
        }
        if (!itemFound) {
            System.out.println("Item '" + itemName + "' not found in the bag.");
        }
    }

    public List<Item> getItemList() {
        return itemList;
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
