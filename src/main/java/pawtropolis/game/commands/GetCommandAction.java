package pawtropolis.game.commands;

import pawtropolis.game.Bag;
import pawtropolis.game.Item;
import pawtropolis.game.Player;
import pawtropolis.game.gamecontroller.CommandController;
import pawtropolis.game.gamecontroller.VideoGameController;

public class GetCommandAction implements CommandController {
   private final Player player;
    private final VideoGameController videoGameController;

    public GetCommandAction(Player player, VideoGameController videoGameController) {
        this.player = player;
        this.videoGameController = videoGameController;
    }

    public void pickItem(String itemName) { //da rivedere
        if (videoGameController.getCurrentRoom().getAvailableItems()
                .stream()
                .anyMatch(item -> item.getName().equals(itemName))) {

            Item item = videoGameController.getCurrentRoom().getAvailableItems()
                    .stream()
                    .filter(i -> i.getName().equals(itemName))
                    .findFirst()
                    .get(); //orElse = null

            player.addItem(item);
            videoGameController.getCurrentRoom().dropItem(item);
        } else {
            System.out.println("Item not found in the room."); //spostare i print fuori dai metodi
        }
    }

    @Override
    public void execute(String[] inputParts) {
        if (inputParts.length == 2) {
            pickItem(inputParts[1]);
        } else {
            System.out.println("Please choose the item to obtain.");
        }
    }
}

