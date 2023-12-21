package pawtropolis.game.commands;

import pawtropolis.game.Player;
import pawtropolis.game.PopulateGame;
import pawtropolis.game.Room;
import pawtropolis.game.gamecontroller.CommandController;
import pawtropolis.game.gamecontroller.VideoGameController;

public class LookCommandAction implements CommandController {
    private final PopulateGame populateGame;


    public LookCommandAction( PopulateGame populateGame) {
        this.populateGame = populateGame;
    }

    private String getAvailableDirections(Room room) {
        return room.getAdjacents().keySet().toString();
    }

    public void lookRoom() {
        System.out.println("You're in the room: " + populateGame.getCurrentRoom().getName());
        System.out.println("Available directions: " + getAvailableDirections(populateGame.getCurrentRoom()));

        if (!populateGame.getCurrentRoom().getAvailableItems().isEmpty()) {
            System.out.println("Available items:");
            populateGame.getCurrentRoom().getAvailableItems().forEach(item ->
                    System.out.println("- " + item.getName() + ": " + item.getDescription()));
        } else {
            System.out.println("There are no items in this room");
        }

        if (!populateGame.getCurrentRoom().getAvailableAnimals().isEmpty()) {
            System.out.println("NPC:");
            populateGame.getCurrentRoom().getAvailableAnimals().forEach(animal ->
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
