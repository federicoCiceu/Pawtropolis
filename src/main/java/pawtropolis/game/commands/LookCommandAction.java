package pawtropolis.game.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pawtropolis.game.gamecontroller.VideoGameController;
import pawtropolis.game.model.Room;
import pawtropolis.game.gamecontroller.CommandController;

@RequiredArgsConstructor
@Component
public class LookCommandAction implements CommandController {
    private final VideoGameController gamePopulation;

    private String getAvailableDirections(Room room) {
        return room.getAdjacentsRoom().keySet().toString();
    }

    public void lookRoom() {
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