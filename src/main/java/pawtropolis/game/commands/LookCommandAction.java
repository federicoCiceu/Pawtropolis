package pawtropolis.game.commands;

import pawtropolis.game.Player;
import pawtropolis.game.Room;
import pawtropolis.game.gamecontroller.CommandController;
import pawtropolis.game.gamecontroller.VideoGameController;

public class LookCommandAction implements CommandController {
    private final VideoGameController videoGameController;


    public LookCommandAction( VideoGameController videoGameController) {
        this.videoGameController = videoGameController;
    }

    private String getAvailableDirections(Room room) {
        return room.getAdjacents().keySet().toString();
    }

    public void lookRoom() {
        System.out.println("You're in the room: " + videoGameController.getCurrentRoom().getName());
        System.out.println("Available directions: " + getAvailableDirections(videoGameController.getCurrentRoom()));

        if (!videoGameController.getCurrentRoom().getAvailableItems().isEmpty()) {
            System.out.println("Available items:");
            videoGameController.getCurrentRoom().getAvailableItems().forEach(item ->
                    System.out.println("- " + item.getName() + ": " + item.getDescription()));
        } else {
            System.out.println("There are no items in this room");
        }

        if (!videoGameController.getCurrentRoom().getAvailableAnimals().isEmpty()) {
            System.out.println("NPC:");
            videoGameController.getCurrentRoom().getAvailableAnimals().forEach(animal ->
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
