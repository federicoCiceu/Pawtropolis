package pawtropolis.game.commands;

import lombok.RequiredArgsConstructor;
import pawtropolis.game.gamecontroller.DirectionEnum;
import pawtropolis.game.gamecontroller.GameFactory;
import pawtropolis.game.model.Room;
import pawtropolis.game.gamecontroller.CommandController;

@RequiredArgsConstructor
public class GoCommandAction implements CommandController {

    private final GameFactory populateGame;

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