package pawtropolis.game.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pawtropolis.game.gamecontroller.DirectionEnum;
import pawtropolis.game.gamecontroller.GameController;
import pawtropolis.game.model.Door;
import pawtropolis.game.model.Item;
import pawtropolis.game.model.Player;
import pawtropolis.game.model.Room;

import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
@RequiredArgsConstructor
@Component
public class GoCommand implements Command {
    private final GameController gamePopulation;
    private final LookCommand lookCommand;

    private void goRoom(DirectionEnum direction) {

        Room currentRoom = gamePopulation.getCurrentRoom();
        Door door = currentRoom.getDoors().get(direction);

        if (door != null) {
            if (door.isLocked()) {
                handleLockedDoor(door);
            } else {
                moveWithoutUnlocking(door);
            }
        }
    }

    private void handleLockedDoor(Door door) {
        Item requiredItem = door.getKey();
        Player player = gamePopulation.getPlayer();

        System.out.println("The door is locked: would you like to use an item to unlock it? (Y/N)");

        Scanner scanner = new Scanner(System.in);
        String playerInput = scanner.nextLine().trim().toLowerCase();

        if (playerInput.equals("y")) {
            unlockDoor(requiredItem, player, door);
        } else if (playerInput.equals("n")) {
            System.out.println("You don't move from the position");
        } else {
            System.out.println("The answer must be Y or N");
        }
    }

    private void unlockDoor(Item requiredItem, Player player, Door door) {
        System.out.println("Type the name of the chosen item");
        Scanner scanner = new Scanner(System.in);
        String answerItemName = scanner.nextLine().toLowerCase().trim();

        if (requiredItem.getName().equals(answerItemName) && player.getBag().getItems().contains(requiredItem)) {
            door.unlock();
            player.getBag().dropItem(requiredItem);
            Room nextRoom = door.getDestinationRoom(gamePopulation.getCurrentRoom());
            door.switchRooms();

            System.out.println("You unlocked the door!");
            gamePopulation.setCurrentRoom(nextRoom);
            lookCommand.lookRoom();
        } else {
            System.out.println("The item you chose is wrong or you don't have it");
        }
    }

    private void moveWithoutUnlocking(Door door) {
        Room nextRoom = door.getDestinationRoom(gamePopulation.getCurrentRoom());
        door.switchRooms();
        gamePopulation.setCurrentRoom(nextRoom);
        lookCommand.lookRoom();
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