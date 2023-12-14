package projectzoo.game;

import projectzoo.animals.Animal;
import projectzoo.domain.Room;

public class Player {

    private String name;
    private int lifePoints;
    private final Bag bag;
    private Room currentRoom;

    public Player(String name, int lifePoints, Room startingRoom) {
        this.name = name;
        this.lifePoints = lifePoints;
        this.bag = new Bag(30);
        this.currentRoom = startingRoom;
    }

    public Bag getBag() {
        return bag;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    public void pickItem(String itemName) {
        Item item = currentRoom.findItem(itemName);

        if (item != null) {
            if (bag.bagUsedSlots() + item.getSlotRequired() <= bag.getAvailableSlot()) {
                bag.addItem(item);
                currentRoom.dropItem(item);
            } else {
                System.out.println("Not enough space in the bag.");
            }
        } else {
            System.out.println("The item is not present in this room.");
        }
    }

    public void dropItem(String itemName) {
        Item item = bag.findItem(itemName);
        if (item != null) {
            bag.dropItem(itemName);
            currentRoom.addItem(item);
        } else {
            System.out.println("Item not found in the bag.");
        }
    }

    public void viewBag() {
        if (bag.bagUsedSlots() != 0){
            for (Item item : bag.getItemList()) {
                System.out.println(" " + item.getName()+" description: " + item.getDescription());
            }
        }else {
            System.out.println("No items found in he bag");
        }
    }

    public void lookRoom() {
        System.out.println("You're in the room: " + name);
        System.out.println("Available directions: " + String.join(", ", currentRoom.getAdjacents().keySet()));

        if (!currentRoom.getAvailableItems().isEmpty()) {
            System.out.println("Available items");
            for (Item item : currentRoom.getAvailableItems()) {
                System.out.println("- " + item.getName() + ": " + item.getDescription());
            }} else {
            System.out.println("There are no items in this room");
        }
        if (!currentRoom.getAvailableAnimals().isEmpty()) {
            System.out.println("NPC: ");
            for (Animal animal : currentRoom.getAvailableAnimals()) {
                System.out.println("- " + animal.getNickname() + "(" + animal.getClass().getSimpleName() + ")");
            }}else {
            System.out.println("There are no NPCs in this room");
        }
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


