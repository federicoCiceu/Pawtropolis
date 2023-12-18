package pawtropolis.game.gamecontroller;

import pawtropolis.animals.Eagle;
import pawtropolis.animals.Lion;
import pawtropolis.animals.Tiger;
import pawtropolis.game.Room;
import pawtropolis.game.Item;
import pawtropolis.game.Player;
import pawtropolis.game.commands.*;

import java.time.LocalDate;
import java.util.*;


public class VideoGameController {
    private final Player player;
    private final Map<Command, CommandController> commandActions;


    private enum Command {
        GO, LOOK, BAG, GET, DROP, EXIT
    }

    public static Room roomMonstadt = new Room("Monstadt");
    public Room roomLiyue = new Room("Liyue");
    public Room roomInazuma = new Room("Inazuma");
    public Room roomSumeru = new Room("Sumeru");
    public Room roomFontaine = new Room("Fontaine");

    public VideoGameController(Player player) {

        this.player = player;
        commandActions = new HashMap<>();
        commandActions.put(Command.GO, new GoCommandAction(player));
        commandActions.put(Command.LOOK, new LookCommandAction(player));
        commandActions.put(Command.BAG, new BagCommandAction(player));
        commandActions.put(Command.GET, new GetCommandAction(player));
        commandActions.put(Command.DROP, new DropCommandAction(player));
        commandActions.put(Command.EXIT, new ExitCommandAction(player));
    }


    Item item1 = new Item("sword", "A Sword user’s Normal Attack is typically a chain of “rapid strikes”", 8);
    Item item2 = new Item("bow", "A Bow user’s Normal Attack launches a chain of fast, mid-ranged shots", 10);
    Item item3 = new Item("polearm", "A Polearm user’s Normal Attack performs a few rapid, consecutive spear strikes", 10);
    Item item4 = new Item("catalyst", "A Catalyst user applies element to enemies when they are hit with Normal Attack", 3);


    Lion lion1 = new Lion("Venti", "Ribs", 4, LocalDate.of(2019, 1, 23), 2.0, 1.28, 40);
    Lion lion2 = new Lion("Zhongli", "Chicken", 8, LocalDate.of(2015, 4, 10), 1.09, 1.17, 36);
    Lion lion3 = new Lion("Raiden", "Pork", 10, LocalDate.of(2013, 12, 5), 2.80, 1.20, 55);

    Tiger tiger1 = new Tiger("Nahida", "Meat", 3, LocalDate.of(2020, 8, 20), 2.50, 0.80, 39);
    Tiger tiger2 = new Tiger("Furina", "Ribs", 14, LocalDate.of(2009, 11, 30), 1.88, 1.10, 47);
    Tiger tiger3 = new Tiger("Neuvilette", "Pork", 8, LocalDate.of(2015, 3, 24), 1.50, 1.80, 34);

    Eagle eagle1 = new Eagle("Xiao", "Rabbit", 30, LocalDate.of(1993, 10, 18), 3.40, 0.69, 23);
    Eagle eagle2 = new Eagle("Dvalin", "Chicken", 30, LocalDate.of(1993, 5, 1), 2.48, 0.90, 33);
    Eagle eagle3 = new Eagle("Ayaka", "Mouse", 1, LocalDate.of(2023, 6, 28), 1.98, 0.45, 13);


    public void startGame() {

        String playerInput;

        roomMonstadt.addAdjacents(DirectionEnum.NORTH, roomLiyue);
        roomLiyue.addAdjacents(DirectionEnum.EAST, roomMonstadt);
        roomLiyue.addAdjacents(DirectionEnum.SOUTH, roomInazuma);
        roomInazuma.addAdjacents(DirectionEnum.NORTH, roomLiyue);
        roomLiyue.addAdjacents(DirectionEnum.WEST, roomSumeru);
        roomSumeru.addAdjacents(DirectionEnum.NORTH, roomFontaine);
        roomSumeru.addAdjacents(DirectionEnum.EAST, roomLiyue);
        roomFontaine.addAdjacents(DirectionEnum.SOUTH, roomSumeru);


        roomMonstadt.addItem(item1);
        roomLiyue.addItem(item2);
        roomInazuma.addItem(item3);
        roomFontaine.addItem(item3);
        player.getBag().addItem(item4);


        roomMonstadt.addAnimal(lion1);
        roomMonstadt.addAnimal(eagle2);
        roomLiyue.addAnimal(lion2);
        roomLiyue.addAnimal(eagle1);
        roomInazuma.addAnimal(lion3);
        roomInazuma.addAnimal(eagle3);
        roomSumeru.addAnimal(tiger1);
        roomFontaine.addAnimal(tiger2);
        roomFontaine.addAnimal(tiger3);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Pawtropolis!");
        System.out.println("What do want to do next? ");
        System.out.println("Type go to change the room");
        System.out.println("Type look to see what's inside the room ");
        System.out.println("Type bag to view  what's inside the bag");
        System.out.println("Type Exit to end your journey");
        System.out.print(" -> ");

        do {
            playerInput = scanner.nextLine().toLowerCase().trim();
            String[] inputParts = playerInput.split(" ", 2);

            Command command = getCommand(inputParts[0]);

            if (command != null) {
                commandActions.get(command).execute(inputParts);
            } else {
                System.out.println("Invalid Input, try again");
            }
        } while (!playerInput.equalsIgnoreCase("EXIT"));
    }

    private Command getCommand(String input) {
        try {
            return Command.valueOf(input.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

}
