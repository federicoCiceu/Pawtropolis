package pawtropolis.game.commands;

import pawtropolis.game.Player;
import pawtropolis.game.Room;
import pawtropolis.game.gamecontroller.CommandController;
import pawtropolis.game.gamecontroller.VideoGameController;

public class GoCommandAction implements CommandController {

    private final VideoGameController videoGameController;


    public GoCommandAction(VideoGameController videoGameController) {
        this.videoGameController = videoGameController;

    }

    public void goRoom(DirectionEnum direction) {
        if (videoGameController.getCurrentRoom().getAdjacents().containsKey(direction)) {
            Room nextRoom = videoGameController.getCurrentRoom().getAdjacents().get(direction);
            videoGameController.setCurrentRoom(nextRoom);
            System.out.println("You have entered " + nextRoom.getName());
        } else {
            System.out.println("Invalid direction. Try again.");
        }
    }


    @Override
    public void execute(String[] inputParts) {
        if (inputParts.length == 2) {
            goRoom(DirectionEnum.parseDirection(inputParts[1]));
        } else {
            System.out.println("Please specify a direction.");
        }
    }
}