package pawtropolis.game.commands;


import pawtropolis.game.model.Player;
import pawtropolis.game.gamecontroller.CommandController;


public class BagCommandAction implements CommandController {

    private final Player player;

    public BagCommandAction(Player player) {
        this.player = player;
    }

    public void viewBag() {
        if (player.bagUsedSlots() != 0) {
            player.getItems()
                    .forEach(item -> System.out.println(" " + item.getName() + " description: " + item.getDescription()));
        } else {
            System.out.println("No items found in the bag");
        }
    }



    @Override
    public void execute(String[] inputParts) {viewBag();}
}

