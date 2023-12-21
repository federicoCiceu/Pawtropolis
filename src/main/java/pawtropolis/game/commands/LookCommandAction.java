package pawtropolis.game.commands;

import pawtropolis.game.PopulateGame;
import pawtropolis.game.Room;
import pawtropolis.game.gamecontroller.CommandController;

public class LookCommandAction implements CommandController {
    private final PopulateGame populateGame;


    public LookCommandAction( PopulateGame populateGame) {
        this.populateGame = populateGame;
    }

    private String getAvailableDirections(Room room) {
        return room.getAdjacentsRoom().keySet().toString();
    }

    public void lookRoom() {
        System.out.println("You're in the room: " + populateGame.getCurrentRoom().getName());
        System.out.println("Available directions: " + getAvailableDirections(populateGame.getCurrentRoom()));

        if (!populateGame.getCurrentRoom().getItems().isEmpty()) {
            System.out.println("Available items:");
            populateGame.getCurrentRoom().getItems().forEach(item ->
                    System.out.println("- " + item.getName() + ": " + item.getDescription()));
        } else {
            System.out.println("There are no items in this room");
        }

        if (!populateGame.getCurrentRoom().getAnimals().isEmpty()) {
            System.out.println("NPC:");
            populateGame.getCurrentRoom().getAnimals().forEach(animal ->
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
