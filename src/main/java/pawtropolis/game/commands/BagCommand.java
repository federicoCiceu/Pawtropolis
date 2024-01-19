package pawtropolis.game.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pawtropolis.game.gamecontroller.GameController;

@RequiredArgsConstructor
@Component
public class BagCommand implements CommandController {
    private final GameController populateGame;

    private void viewBag() {
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