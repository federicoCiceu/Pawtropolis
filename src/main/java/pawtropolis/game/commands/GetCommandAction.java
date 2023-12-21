package pawtropolis.game.commands;

import pawtropolis.game.Item;
import pawtropolis.game.Player;
import pawtropolis.game.PopulateGame;
import pawtropolis.game.gamecontroller.CommandController;

import java.util.Optional;

public class GetCommandAction implements CommandController {
   private final Player player;
    private final PopulateGame populateGame;

    public GetCommandAction(Player player, PopulateGame populateGame) {
        this.player = player;
        this.populateGame = populateGame;
    }

    public void pickItem(String itemName) {
        Optional<Item> optionalItem = populateGame.getCurrentRoom().getItems()
                .stream()
                .filter(item -> item.getName().equals(itemName))
                .findFirst();

        if (optionalItem.isPresent()) {
            Item item = optionalItem.get();
            player.addItem(item);
            populateGame.getCurrentRoom().dropItem(item);
        } else {
            System.out.println("Item not found in the current room");
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

