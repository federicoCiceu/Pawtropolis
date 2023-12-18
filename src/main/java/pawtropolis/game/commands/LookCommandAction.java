package pawtropolis.game.commands;

import pawtropolis.game.Player;
import pawtropolis.game.gamecontroller.CommandController;

public class LookCommandAction implements CommandController {
    private final Player player;

    public LookCommandAction(Player player) {
        this.player = player;
    }

    @Override
    public void execute(String[] inputParts) {
        player.lookRoom();
    }
}
