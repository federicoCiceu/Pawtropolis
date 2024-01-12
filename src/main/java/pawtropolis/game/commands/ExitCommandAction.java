package pawtropolis.game.commands;

import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import pawtropolis.game.gamecontroller.CommandController;
@NoArgsConstructor
@Component
public class ExitCommandAction implements CommandController {

    @Override
    public void execute(String[] inputParts) {
        System.out.println("Pawtropolis hopes to see you again!");
    }
}
