package pawtropolis.game.model;

import pawtropolis.animals.Animal;
import pawtropolis.game.gamecontroller.DirectionEnum;

import java.util.*;


public class Room {
    private String name;
    private final List<Item> items;
    private List<Animal> animals;
    private final EnumMap<DirectionEnum, Room> adjacentsRoom;


    public Room(String roomName) {
        this.name = roomName;
        this.adjacentsRoom = new EnumMap<>(DirectionEnum.class);
        this.items = new ArrayList<>();
        this.animals = new ArrayList<>();

    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void dropItem(Item item) {
        items.remove(item);
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void addAdjacents(DirectionEnum direction, Room nextRoom) {
        adjacentsRoom.put(direction, nextRoom);
        nextRoom.adjacentsRoom.put(DirectionEnum.getOppositeDirection(direction), this);
    }

    public Map<DirectionEnum, Room> getAdjacentsRoom() {
        return adjacentsRoom;
    }

    public String getName() {
        return name;
    }


    public List<Item> getItems() {
        return items;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public void setName(String name) {
        this.name = name;
    }




}
