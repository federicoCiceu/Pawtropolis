package pawtropolis.game.gamecontroller;

import pawtropolis.animals.Eagle;
import pawtropolis.animals.Lion;
import pawtropolis.animals.Tiger;
import pawtropolis.game.*;
import pawtropolis.game.commands.*;

import java.time.LocalDate;
import java.util.*;


public class VideoGameController {

    private final EnumMap<CommandEnum, CommandController> commandActions;
    private final Player player;

    public VideoGameController(Player player) {
        this.player = player;
        this.commandActions = new EnumMap<>(CommandEnum.class);
    }

    public void commandAssignment(PopulateGame populateGame){

        commandActions.put(CommandEnum.GO, new GoCommandAction(populateGame));
        commandActions.put(CommandEnum.LOOK, new LookCommandAction( populateGame));
        commandActions.put(CommandEnum.BAG, new BagCommandAction(player));
        commandActions.put(CommandEnum.GET, new GetCommandAction(player, populateGame ));
        commandActions.put(CommandEnum.DROP, new DropCommandAction(player, populateGame));
        commandActions.put(CommandEnum.EXIT, new ExitCommandAction());
    }


    public void startGame() {

        String playerInput;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Pawtropolis!");
        System.out.println("What do want to do next? ");
        System.out.println("Type go to change the room");
        System.out.println("Type look to see what's inside the room ");
        System.out.println("Type bag to view  what's inside the bag");
        System.out.println("Type Exit to end your journey");


        do {
            System.out.print(" -> ");
            playerInput = scanner.nextLine().toLowerCase().trim();
            String[] inputParts = playerInput.split(" ", 2);

            CommandEnum command = getCommand(inputParts[0]);

            if (command != null) {
                if (commandActions.containsKey(command)) {
                    commandActions.get(command).execute(inputParts);
                } else {
                    System.out.println("Invalid command, try again");
                }
            } else {
                System.out.println("Invalid Input, try again");
            }
        } while (!playerInput.equalsIgnoreCase("EXIT"));
    }

    private CommandEnum getCommand(String input) {
        try {
            return CommandEnum.valueOf(input.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

}
