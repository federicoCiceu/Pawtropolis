package pawtropolis.game.commands;

import lombok.NoArgsConstructor;
import pawtropolis.game.gamecontroller.CommandController;
@NoArgsConstructor
public class ExitCommandAction  implements CommandController {

    @Override
    public void execute(String[] inputParts) {
        System.out.println("Pawtropolis hopes to see you again!");
    }
}
