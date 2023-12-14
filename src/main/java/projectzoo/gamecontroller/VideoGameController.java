package projectzoo.gamecontroller;

import projectzoo.animals.Eagle;
import projectzoo.animals.Lion;
import projectzoo.animals.Tiger;
import projectzoo.domain.Room;
import projectzoo.game.Item;
import projectzoo.game.Player;

import java.time.LocalDate;
import java.util.*;

public class VideoGameController {
    private final Player player;
    private static final String NORTH = "north";
    private static final String SOUTH = "south";
    private static final String WEST = "west";
    private static final String EAST = "east";

    public static Room roomMonstadt = new Room("Monstadt");
    public  Room roomLiyue = new Room("Liyue");
    public  Room roomInazuma = new Room("Inazuma");
    public  Room roomSumeru = new Room("Sumeru");
    public  Room roomFontaine = new Room("Fontaine");

    public VideoGameController(Player player) {
        this.player = player;
    }


    // Create Items
    Item item1 = new Item("sword", "A Sword user’s Normal Attack is typically a chain of “rapid strikes”", 8);
    Item item2 = new Item("bow", "A Bow user’s Normal Attack launches a chain of fast, mid-ranged shots", 10);
    Item item3 = new Item("polearm", "A Polearm user’s Normal Attack performs a few rapid, consecutive spear strikes", 10);
    Item item4 = new Item("catalyst", "A Catalyst user applies element to enemies when they are hit with Normal Attack", 3);

    // Create Animals
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

        // Connect Rooms (direction - roomName)
        roomMonstadt.addAdjacents(WEST, roomLiyue);
        roomLiyue.addAdjacents(EAST, roomMonstadt);
        roomLiyue.addAdjacents(SOUTH, roomInazuma);
        roomInazuma.addAdjacents(NORTH, roomLiyue);
        roomLiyue.addAdjacents(WEST, roomSumeru);
        roomSumeru.addAdjacents(NORTH, roomFontaine);
        roomSumeru.addAdjacents(EAST, roomLiyue);
        roomFontaine.addAdjacents(SOUTH, roomSumeru);

        // Add Items to Rooms/Bag
        roomMonstadt.addItem(item1);
        roomLiyue.addItem(item2);
        roomInazuma.addItem(item3);
        roomFontaine.addItem(item3);
        player.getBag().addItem(item4);

        // Add NPCs to Rooms
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

            switch (inputParts[0]) {
                case "go":
                    if (inputParts.length == 2) {
                        goRoom(inputParts[1]);
                    } else {
                        System.out.println("Please specify a direction.");
                    }
                    break;
                case "look":
                    lookRoom();
                    break;
                case "bag":
                    viewBag();
                    break;
                case "get":
                    if (inputParts.length == 2) {
                        getItem(inputParts[1]);
                    } else {
                        System.out.println("Please choose the item to obtain.");
                    }
                    break;
                case "drop":
                    if (inputParts.length == 2) {
                        dropItem(inputParts[1]);
                    } else {
                        System.out.println("Please choose the item to drop.");
                    }
                    break;
                case "exit":
                    System.out.println("Pawtropolis hopes to see you again!");
                    break;
                default:
                    System.out.println("Invalid Input, try again");
            }
        } while (!playerInput.equalsIgnoreCase("EXIT" ));
    }

    private void goRoom(String inputPart) {
        if (player.getCurrentRoom().getAdjacents().containsKey(inputPart)) {
            Room nextRoom = player.getCurrentRoom().getAdjacents().get(inputPart);
            player.setCurrentRoom(nextRoom);
            System.out.println("You have entered " + nextRoom.getName());
            player.getCurrentRoom().lookRoom();
        } else {
            System.out.println("Invalid direction. Try again.");
        }
    }

    private void lookRoom() {
        player.getCurrentRoom().lookRoom();
    }

    private void viewBag() {
       player.getBag().viewBag();
    }

    private void getItem(String inputPart) {
        player.pickItem(inputPart);
    }

    private void dropItem(String inputPart) {
        player.dropItem(inputPart);
    }
}
