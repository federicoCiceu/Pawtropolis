package pawtropolis.game.commands;

import pawtropolis.game.Player;
import pawtropolis.game.gamecontroller.CommandController;

public class GoCommandAction implements CommandController {
    private final Player player;

    public GoCommandAction(Player player) {
        this.player = player;
    }

    @Override
    public void execute(String[] inputParts) {
        if (inputParts.length == 2) {
            player.goRoom(DirectionEnum.parseDirection(inputParts[1]));
        } else {
            System.out.println("Please specify a direction.");
        }
    }
}