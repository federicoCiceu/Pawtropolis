package pawtropolis.game.commands;

import pawtropolis.game.Player;
import pawtropolis.game.gamecontroller.CommandController;

public class BagCommandAction implements CommandController {
    private final Player player;

    public BagCommandAction(Player player) {
        this.player = player;
    }

    @Override
    public void execute(String[] inputParts) {
        player.viewBag();
    }
}

