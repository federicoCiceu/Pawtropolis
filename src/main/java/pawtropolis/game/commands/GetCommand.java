package pawtropolis.game.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pawtropolis.game.gamecontroller.GameController;
import pawtropolis.game.model.Item;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class GetCommand implements Command {
    private final GameController gamePopulation;

    private void pickItem(String itemName) {
        Optional<Item> optionalItem = gamePopulation.getCurrentRoom().getItems()
                .stream()
                .filter(item -> item.getName().equals(itemName))
                .findFirst();
        if (optionalItem.isPresent()) {
            Item item = optionalItem.get();
            if(gamePopulation.getPlayer().bagUsedSlots() + item.getSlotRequired() < gamePopulation.getPlayer().getBag().getSlot()) {
                gamePopulation.getPlayer().addItem(item);
                gamePopulation.getCurrentRoom().dropItem(item);
            }else{
                System.out.println("The bag is full, cant add item");
            }
        } else {
            System.out.println("Item not found in the current room");
        }
    }

    @Override
    public void execute(String[] inputParts) {
        if (inputParts.length == 2) {
            pickItem(inputParts[1]);
        } else {
            System.out.println("Please choose the item to obtain.");
        }
    }
}