package pawtropolis.game.commands;

<<<<<<< Updated upstream
import pawtropolis.game.Item;
import pawtropolis.game.Player;
import pawtropolis.game.PopulateGame;
=======
import pawtropolis.game.model.Item;
import pawtropolis.game.model.Player;
import pawtropolis.game.gamecontroller.GameFactory;
>>>>>>> Stashed changes
import pawtropolis.game.gamecontroller.CommandController;

import java.util.Optional;

public class DropCommandAction implements CommandController {
    private final Player player;
    private final PopulateGame populateGame;

    public DropCommandAction(Player player, PopulateGame populateGame) {
        this.player  = player;
        this.populateGame = populateGame;
    }

    public void removeItem(String itemName) {
        Optional<Item> optionalItem = player.getItems()
                .stream()
                .filter(item -> item.getName().equals(itemName))
                .findFirst();

        if (optionalItem.isPresent()) {
            Item item = optionalItem.get();
            player.removeItem(item);
            populateGame.getCurrentRoom().addItem(item);
        } else {
            System.out.println("Item not found in the current room");
        }
    }

    @Override
    public void execute(String[] inputParts) {
        if (inputParts.length == 2) {
            removeItem(inputParts[1]);
        } else {
            System.out.println("Please choose the item to drop.");
        }
    }
}
