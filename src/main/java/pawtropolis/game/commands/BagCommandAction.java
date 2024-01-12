package pawtropolis.game.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import pawtropolis.game.gamecontroller.VideoGameController;
import pawtropolis.game.model.Player;
import pawtropolis.game.gamecontroller.CommandController;

@RequiredArgsConstructor
@Component
public class BagCommandAction implements CommandController {
    @Autowired
    private VideoGameController populateGame;

    public void viewBag() {
        if (populateGame.getPlayer().bagUsedSlots() != 0) {
            populateGame.getPlayer().getItems().forEach(item -> System.out.println(" " + item.getName() + " description: " + item.getDescription()));
        } else {
            System.out.println("No items found in the bag");
        }
    }

    @Override
    public void execute(String[] inputParts) {
        viewBag();
    }
}