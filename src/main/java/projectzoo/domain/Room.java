package projectzoo.domain;

import projectzoo.animals.Animal;
import projectzoo.game.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Room {
    private String name;
    private final List<Item> availableItems;
    private List<Animal> availableAnimals;
    private final Map<String, Room> adjacents;

    public Room(String roomName) {
        this.name = roomName;
        this.availableItems = new ArrayList<>();
        this.availableAnimals = new ArrayList<>();
        this.adjacents = new HashMap<>();
    }

    public void addItem(Item item) {
        availableItems.add(item);
    }

    public void addAnimal(Animal animal) {
        availableAnimals.add(animal);
    }

    public void addAdjacents(String direction, Room currentRoom) {
        adjacents.put(direction, currentRoom);
    }

    public String getName() {
        return name;
    }

    public Map<String, Room> getAdjacents() {
        return adjacents;
    }



        public void dropItem (Item item){
            availableItems.remove(item);
        }

        public Item findItem (String itemName){
            for (Item item : availableItems) {
                if (item.getName().equalsIgnoreCase(itemName)) {
                    return item;
                }
            }
            return null;
        }

        public void setName(String name){
            this.name = name;
        }

        public void getAdjacents (String direction){
            adjacents.get(direction);
        }

        public List<Item> getAvailableItems () {
            return availableItems;
        }

        public List<Animal> getAvailableAnimals () {
            return availableAnimals;
        }

        public void setAvailableAnimals (List <Animal> availableAnimals) {
            this.availableAnimals = availableAnimals;
        }



}
