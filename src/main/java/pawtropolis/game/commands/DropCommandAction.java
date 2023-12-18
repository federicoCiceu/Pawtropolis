package pawtropolis.game.commands;

import pawtropolis.game.Player;
import pawtropolis.game.gamecontroller.CommandController;

public class DropCommandAction implements CommandController {
    private final Player player;

    public DropCommandAction(Player player) {
        this.player = player;
    }

    @Override
    public void execute(String[] inputParts) {
        if (inputParts.length == 2) {
            player.dropItem(inputParts[1]);
        } else {
            System.out.println("Please choose the item to drop.");
        }
    }
}
