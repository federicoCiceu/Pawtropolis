package pawtropolis.game.commands;

import pawtropolis.game.gamecontroller.DirectionEnum;
import pawtropolis.game.gamecontroller.GameFactory;
import pawtropolis.game.Room;
import pawtropolis.game.gamecontroller.CommandController;

public class GoCommandAction implements CommandController {

    private final GameFactory populateGame;


    public GoCommandAction(GameFactory populateGame) {
        this.populateGame = populateGame;

    }

    public void goRoom(DirectionEnum direction) {
        if (populateGame.getCurrentRoom().getAdjacentsRoom().containsKey(direction)) {
            Room nextRoom = populateGame.getCurrentRoom().getAdjacentsRoom().get(direction);
            populateGame.setCurrentRoom(nextRoom);
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