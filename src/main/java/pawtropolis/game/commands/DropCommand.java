package pawtropolis.game.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pawtropolis.game.gamecontroller.GameController;
import pawtropolis.game.model.Item;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class DropCommand implements CommandController {
    private final GameController gamePopulation;

    private void dropItem(String itemName) {
        Optional<Item> optionalItem = gamePopulation.getPlayer().getItems()
                .stream()
                .filter(item -> item.getName().equals(itemName))
                .findFirst();

        if (optionalItem.isPresent()) {
            Item item = optionalItem.get();
            gamePopulation.getPlayer().dropItem(item);
            gamePopulation.getCurrentRoom().addItem(item);
        } else {
            System.out.println("Item not found in the bag");
        }
    }

    @Override
    public void execute(String[] inputParts) {
        if (inputParts.length == 2) {
            dropItem(inputParts[1]);
        } else {
            System.out.println("Please choose the item to drop.");
        }
    }
}