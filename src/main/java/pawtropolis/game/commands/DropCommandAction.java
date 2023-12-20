package pawtropolis.game.commands;

import pawtropolis.game.Bag;
import pawtropolis.game.Item;
import pawtropolis.game.Player;
import pawtropolis.game.gamecontroller.CommandController;
import pawtropolis.game.gamecontroller.VideoGameController;

public class DropCommandAction implements CommandController {
    private Player player;
    private final VideoGameController videoGameController;

    public DropCommandAction(Player player, VideoGameController videoGameController) {
        this.player  = player;
        this.videoGameController = videoGameController;
    }

    public void dropItem(String itemName) {
        if (player.getItemList()
                .stream()
                .anyMatch(item -> item.getName().equals(itemName))) {

            Item item = player.getItemList()
                    .stream()
                    .filter(i -> i.getName().equals(itemName))
                    .findFirst()
                    .get();

            player.dropItem(itemName);
            videoGameController.getCurrentRoom().addItem(item);
        } else {
            System.out.println("Item not found in the bag.");
        }
    }

    @Override
    public void execute(String[] inputParts) {
        if (inputParts.length == 2) {
            dropItem(inputParts[1]);
        } else {
            System.out.println("Please choose the item to drop.");
        }
    }
}
