package pawtropolis.game;

import pawtropolis.animals.Animal;
import pawtropolis.game.commands.DirectionEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Room {
    private String name;
    private final List<Item> availableItems;
    private List<Animal> availableAnimals;
    private final Map<DirectionEnum, Room> adjacents;


    public Room(String roomName) {
        this.name = roomName;
        this.adjacents = new HashMap<>();
        this.availableItems = new ArrayList<>();
        this.availableAnimals = new ArrayList<>();

    }

    public void addItem(Item item) {
        availableItems.add(item);
    }

    public void dropItem(Item item) {
        availableItems.remove(item);
    }

    public void addAnimal(Animal animal) {
        availableAnimals.add(animal);
    }

    public void addAdjacents(DirectionEnum direction, Room currentRoom) {
        adjacents.put(direction, currentRoom);
    }

    public Map<DirectionEnum, Room> getAdjacents() {
        return adjacents;
    }

    public String getName() {
        return name;
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

    public void setName(String name) {
        this.name = name;
    }




}
