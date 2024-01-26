package pawtropolis.game.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import pawtropolis.game.gamecontroller.DirectionEnum;

@Data
@AllArgsConstructor
public class Door {
    private boolean locked;
    private final Item key;
    private Room room1;
    private Room room2;


    public void unlock() {
        locked = false;
    }

    public Room getDestinationRoom(Room currentRoom) {
        return (currentRoom == room1) ? room2 : room1;
    }

    public void switchRooms() {
        Room temp = room1;
        room1 = room2;
        room2 = temp;
    }
}
