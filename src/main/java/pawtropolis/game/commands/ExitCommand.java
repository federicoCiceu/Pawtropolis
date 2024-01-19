package pawtropolis.game.commands;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import pawtropolis.game.gamecontroller.GameController;

@RequiredArgsConstructor
@Component
public class ExitCommand implements CommandController {
    private final GameController gameController;
    @Override
    public void execute(String[] inputParts) {
        System.out.println("Pawtropolis hopes to see you again!");
        gameController.setGameEnd(true);
    }
}
