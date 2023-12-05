package projectzoo.domain;

import projectzoo.animals.Animal;
import projectzoo.game.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {
    private String roomName;
    private final List<Item> availableItems;
    private List<Animal> availableAnimals;
    private Map<String, String> adjacents;

    public Room(String roomName) {
        this.roomName = roomName;
        this.availableItems =new ArrayList<>();
        this.availableAnimals = new ArrayList<>();
        this.adjacents = new HashMap<>();
    }

    public void addItem(Item item) {
        availableItems.add(item);
    }

    public void dropItem(String itemName) {
        availableItems.remove(itemName);
    }

    public void addAnimal(Animal animal) {
        availableAnimals.add(animal);
    }

    public void addAdjacents(String direction, String adjacentRoom){
        adjacents.put (direction,adjacentRoom);
    }

    public void getAdjacents(String direction){
        adjacents.get(direction);
    }

    public void lookRoom(){
    System.out.println("You're in the room: " + roomName);
        System.out.println("Available items");
        for (Item item : availableItems){
            System.out.println("- " + item.getNameItem() + ": " +  item.getDescription());
        }
        System.out.println("NPC: ");
        for (Animal animal : availableAnimals){
            System.out.println("- " + animal.getNickname() + "(" + animal.getClass().getSimpleName() +")");
        }
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }


    public List<Item> getAvailableItems() {
        return availableItems;
    }

    public List<Animal> getAvailableAnimals() {
        return availableAnimals;
    }

    public void setAvailableAnimals(List<Animal> availableAnimals) {
        this.availableAnimals = availableAnimals;
    }

    public Map<String, String> getAdjacents() {
        return adjacents;
    }

    public void setAdjacents(Map<String, String> adjacents) {
        this.adjacents = adjacents;
    }
}
