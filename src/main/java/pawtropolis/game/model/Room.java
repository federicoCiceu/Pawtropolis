package pawtropolis.game.model;

import lombok.Data;
import pawtropolis.animals.Animal;
import pawtropolis.game.gamecontroller.DirectionEnum;

import java.util.*;

@Data
public class Room {
    private String name;
    private final List<Item> items;
    private List<Animal> animals;
    private EnumMap<DirectionEnum, Door> doors;

    public Room(String roomName) {
        this.name = roomName;
        this.doors = new EnumMap<>(DirectionEnum.class);
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

    public void addDoor(DirectionEnum direction, Door door) {
        doors.put(direction, door);
        Room oppositeRoom = door.getDestinationRoom(this);
        oppositeRoom.doors.put(DirectionEnum.getOppositeDirection(direction), door);
    }

    public Map<DirectionEnum, Door> getDoors() {
        return doors;
    }

    public void openDoor(DirectionEnum direction, Item key) {
        Door door = doors.get(direction);
        if (door != null && door.isLocked() && door.getKey().equals(key)) {
            door.unlock();
        }
    }
}
