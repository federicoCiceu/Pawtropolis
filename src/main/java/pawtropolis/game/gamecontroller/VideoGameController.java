package pawtropolis.game.gamecontroller;

import lombok.Getter;
import pawtropolis.game.commands.*;
import pawtropolis.game.model.Player;

import java.util.*;

public class VideoGameController {
    @Getter
    private final Player player;
    private final EnumMap<CommandEnum, CommandController> commandActions;

    public VideoGameController(Player player) {
        this.player = player;
        this.commandActions = new EnumMap<>(CommandEnum.class);
    }

    public void commandAssignment(GameFactory populateGame){

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

        boolean gameEnd = false;
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
            if(inputParts[0].equals("exit")){
                gameEnd = true;
            }
        } while (!gameEnd);
    }

    private CommandEnum getCommand(String input) {
        for (CommandEnum command : CommandEnum.values()) {
            if (command.getCommand().equalsIgnoreCase(input.trim())) {
                return command;
            }
        }
        return null;
    }

}
