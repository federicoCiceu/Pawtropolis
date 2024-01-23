package pawtropolis.game.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pawtropolis.game.gamecontroller.DirectionEnum;
import pawtropolis.game.gamecontroller.GameController;
import pawtropolis.game.model.Door;
import pawtropolis.game.model.Item;
import pawtropolis.game.model.Player;
import pawtropolis.game.model.Room;

import java.util.Objects;
import java.util.Scanner;

@RequiredArgsConstructor
@Component
public class GoCommand implements Command {
    private final GameController gamePopulation;
    private final LookCommand lookCommand;

    private void goRoom(DirectionEnum direction) {
        if (gamePopulation.getCurrentRoom().getAdjacentsRoom().containsKey(direction)) {
            Door door = gamePopulation.getCurrentRoom().getDoors().get(direction);

            if (door != null && door.isLocked()) {
                Item requiredItem = door.getKey();
                Player player = gamePopulation.getPlayer();
                System.out.println("The door is locked: would you like to use an item to unlock it?");
                System.out.println("The required item is : " + requiredItem.getName());
                System.out.println("The answer must be Y or N");

                Scanner scanner = new Scanner(System.in);
                String playerInput = scanner.nextLine().trim();

                if (Objects.equals(playerInput, "Y")) {
                    System.out.println("Type the name of the chosen item");
                    String answerItemName = scanner.nextLine().toLowerCase().trim();

                    if (requiredItem.toString().equals(answerItemName) || player.getBag().getItems().contains(requiredItem)) {
                        gamePopulation.getCurrentRoom().openDoor(direction, requiredItem);
                        gamePopulation.getPlayer().getBag().dropItem(requiredItem);
                        Room nextRoom = gamePopulation.getCurrentRoom().getAdjacentsRoom().get(direction);
                        System.out.println("You unlocked the door!");
                        gamePopulation.setCurrentRoom(nextRoom);
                        lookCommand.lookRoom();
                    }else{
                        System.out.println("The item you chose is wrong or you don't have it");
                    }
                } else if(Objects.equals(playerInput, "N")) {
                    System.out.println("You don't move from the position");
                } else{
                    System.out.println("The answer must be Y or N");
                }
            } else {
                Room nextRoom = gamePopulation.getCurrentRoom().getAdjacentsRoom().get(direction);
                gamePopulation.setCurrentRoom(nextRoom);
                lookCommand.lookRoom();
            }
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