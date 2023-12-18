package pawtropolis.game.commands;

import pawtropolis.game.Player;
import pawtropolis.game.gamecontroller.CommandController;

public class ExitCommandAction  implements CommandController {
    private final Player player;

    public ExitCommandAction(Player player) {
        this.player = player;
    }

    @Override
    public void execute(String[] inputParts) {
        System.out.println("Pawtropolis hopes to see you again!");
    }
}
