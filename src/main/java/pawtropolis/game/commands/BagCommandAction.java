package pawtropolis.game.commands;

import pawtropolis.game.Bag;
import pawtropolis.game.Player;
import pawtropolis.game.gamecontroller.CommandController;
import pawtropolis.game.gamecontroller.VideoGameController;

public class BagCommandAction implements CommandController {

    private final Player player;

    public BagCommandAction(Player player) {
        this.player = player;
    }

    public void viewBag() {
        if (player.bagUsedSlots() != 0) {
            player.getItemList()
                    .forEach(item -> System.out.println(" " + item.getName() + " description: " + item.getDescription()));
        } else {
            System.out.println("No items found in the bag");
        }
    }

    @Override
    public void execute(String[] inputParts) {viewBag();}
}

