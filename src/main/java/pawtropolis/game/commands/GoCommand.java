package pawtropolis.game.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pawtropolis.game.gamecontroller.DirectionEnum;
import pawtropolis.game.gamecontroller.GameController;
import pawtropolis.game.model.Room;

@RequiredArgsConstructor
@Component
public class GoCommand implements Command {
    private final GameController gamePopulation;

    private void goRoom(DirectionEnum direction) {
        if (gamePopulation.getCurrentRoom().getAdjacentsRoom().containsKey(direction)) {
            Room nextRoom = gamePopulation.getCurrentRoom().getAdjacentsRoom().get(direction);
            gamePopulation.setCurrentRoom(nextRoom);
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