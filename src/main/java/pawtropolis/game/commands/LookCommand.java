package pawtropolis.game.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pawtropolis.game.gamecontroller.DirectionEnum;
import pawtropolis.game.gamecontroller.GameController;
import pawtropolis.game.model.Door;
import pawtropolis.game.model.Room;

import java.util.Map;

@RequiredArgsConstructor
@Component
public class LookCommand implements Command {
    private final GameController gamePopulation;

    private String getAvailableDirections(Room room) {
        StringBuilder directions = new StringBuilder();

        for (Map.Entry<DirectionEnum, Door> entry : room.getDoors().entrySet()) {
            DirectionEnum directionEnum = entry.getKey();
            Door door = entry.getValue();

            String doorStatus = door.isLocked() ? "locked" : "unlocked";
            directions.append(directionEnum).append(" door (").append(doorStatus).append("), ");
        }

        if (!directions.isEmpty()) {
            directions.setLength(directions.length() - 2);
        }

        return directions.toString();
    }

    void lookRoom() {
        System.out.println("You're in the room: " + gamePopulation.getCurrentRoom().getName());
        System.out.println("Available directions: " + getAvailableDirections(gamePopulation.getCurrentRoom()));

        if (!gamePopulation.getCurrentRoom().getItems().isEmpty()) {
            System.out.println("Available items:");
            gamePopulation.getCurrentRoom().getItems().forEach(item ->
                    System.out.println("- " + item.getName() + ": " + item.getDescription()));
        } else {
            System.out.println("There are no items in this room");
        }

        if (!gamePopulation.getCurrentRoom().getAnimals().isEmpty()) {
            System.out.println("NPC:");
            gamePopulation.getCurrentRoom().getAnimals().forEach(animal ->
                    System.out.println("- " + animal.getNickname() + " (" +
                            animal.getClass().getSimpleName() + ")"));
        } else {
            System.out.println("There are no NPCs in this room");
        }
    }

    @Override
    public void execute(String[] inputParts) {
        lookRoom();
    }
}