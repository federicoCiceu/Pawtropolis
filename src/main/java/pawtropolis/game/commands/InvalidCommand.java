package pawtropolis.game.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pawtropolis.game.gamecontroller.GameController;

@RequiredArgsConstructor
@Component
public class InvalidCommand implements CommandController{
    private final GameController gamePopulation;

    @Override
    public void execute(String[] inputParts) {
        System.out.println("Invalid Command");
    }

}
