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
    private Map<String, Room> adjacentRoom;


    public Room(String roomName) {
        this.roomName = roomName;
        this.availableItems =new ArrayList<>();
        this.availableAnimals = new ArrayList<>();
        this.adjacentRoom = new HashMap<>();
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

    public void addAdjacents(String direction, Room currentRoom){
        adjacentRoom.put(direction,currentRoom);
    }

    public void getAdjacents(String direction){
        adjacentRoom.get(direction);
    }

    public void goRoom( Room currentRoom, String direction){
        if(!isValidDirection(direction)){
            System.out.println("invalid direction");
            return;
        }
        Room adjacentRoom = this.adjacentRoom.get(direction);
        if (adjacentRoom == null){
            System.out.println("there's no room in that direction");
            return;
        }
        currentRoom = adjacentRoom;
        System.out.println("you are now in " + currentRoom.getRoomName());
    }

    private boolean isValidDirection(String direction){
        return direction.equals("north") || direction.equals("south") || direction.equals("east") || direction.equals("west");
    }

    public void lookRoom(){
    System.out.println("You're in the room: " + adjacentRoom);
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

    public Map<String, Room> getAdjacentRoom() {
        return adjacentRoom;
    }

    public void setAdjacentRoom(Map<String, Room> adjacentRoom) {
        this.adjacentRoom = adjacentRoom;
    }
}
