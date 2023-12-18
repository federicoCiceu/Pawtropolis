package pawtropolis.game.commands;

import pawtropolis.game.Player;
import pawtropolis.game.gamecontroller.CommandController;

public class GetCommandAction implements CommandController {
    private final Player player;

    public GetCommandAction(Player player) {
        this.player = player;
    }

    @Override
    public void execute(String[] inputParts) {
        if (inputParts.length == 2) {
            player.pickItem(inputParts[1]);
        } else {
            System.out.println("Please choose the item to obtain.");
        }
    }
}

