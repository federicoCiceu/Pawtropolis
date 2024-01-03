package pawtropolis.game.commands;

import pawtropolis.game.Item;
import pawtropolis.game.Player;
import pawtropolis.game.gamecontroller.GameFactory;
import pawtropolis.game.gamecontroller.CommandController;

import java.util.Optional;

public class DropCommandAction implements CommandController {
    private final Player player;
    private final GameFactory populateGame;

    public DropCommandAction(Player player, GameFactory populateGame) {
        this.player  = player;
        this.populateGame = populateGame;
    }

    public void dropItem(String itemName) {
        Optional<Item> optionalItem = player.getItems()
                .stream()
                .filter(item -> item.getName().equals(itemName))
                .findFirst();

        if (optionalItem.isPresent()) {
            Item item = optionalItem.get();
            player.dropItem(item);
            populateGame.getCurrentRoom().addItem(item);
        } else {
            System.out.println("Item not found in the current room");
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
