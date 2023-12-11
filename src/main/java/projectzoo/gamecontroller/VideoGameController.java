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
    private final Scanner scanner;


    public static Room roomHell = new Room("Hell");
    public  Room roomParadise = new Room("Paradise");
    public  Room roomEarth = new Room("Limbo");
    public  Room roomLimbo = new Room("Earth");


    public VideoGameController(Player player, Scanner scanner) {
        this.player = player;
        this.scanner = scanner;
    }

    // Create Items
    Item item1 = new Item("sword", "A Sword user’s Normal Attack is typically a chain of “rapid strikes”", 8);
    Item item2 = new Item("bow", "A Bow user’s Normal Attack launches a chain of fast, mid-ranged shots", 10);
    Item item3 = new Item("polearm", "A Polearm user’s Normal Attack performs a few rapid, consecutive spear strikes", 10);
    Item item4 = new Item("catalyst", "A Catalyst user applies element to enemies when they are hit with Normal Attack", 3);

    // Create Animals
    Lion lion1 = new Lion("Nala", "Ribs", 4, LocalDate.of(2019, 1, 23), 2.0, 1.28, 40);
    Lion lion2 = new Lion("Leo", "Chicken", 8, LocalDate.of(2015, 4, 10), 1.09, 1.17, 36);
    Lion lion3 = new Lion("Rin", "Pork", 10, LocalDate.of(2013, 12, 5), 2.80, 1.20, 55);

    Tiger tiger1 = new Tiger("Baghera", "Meat", 3, LocalDate.of(2020, 8, 20), 2.50, 0.80, 39);
    Tiger tiger2 = new Tiger("Max", "Ribs", 14, LocalDate.of(2009, 11, 30), 1.88, 1.10, 47);
    Tiger tiger3 = new Tiger("Kai", "Pork", 8, LocalDate.of(2015, 3, 24), 1.50, 1.80, 34);

    Eagle eagle1 = new Eagle("Neon", "Rabbit", 30, LocalDate.of(1993, 10, 18), 3.40, 0.69, 23);
    Eagle eagle2 = new Eagle("Bubi", "Chicken", 30, LocalDate.of(1993, 5, 1), 2.48, 0.90, 33);
    Eagle eagle3 = new Eagle("Mina", "Mouse", 1, LocalDate.of(2023, 6, 28), 1.98, 0.45, 13);


    public void startGame() {

        String playerInput;

        // Connect Rooms (direction - roomName)
        roomHell.addAdjacents(NORTH, roomParadise);
        roomParadise.addAdjacents(SOUTH, roomHell);
        roomParadise.addAdjacents(EAST, roomEarth);
        roomEarth.addAdjacents(WEST, roomParadise);
        roomEarth.addAdjacents(EAST, roomLimbo);
        roomLimbo.addAdjacents(WEST, roomEarth);


        // Add Items to Rooms/Bag
        roomHell.addItem(item1);
        roomParadise.addItem(item2);
        roomEarth.addItem(item3);
        player.getBag().addItem(item4);


        // Add NPCs to Rooms
        roomHell.addAnimal(lion1);
        roomHell.addAnimal(tiger1);
        roomParadise.addAnimal(lion2);
        roomParadise.addAnimal(tiger2);
        roomLimbo.addAnimal(lion3);
        roomLimbo.addAnimal(eagle3);
        roomEarth.addAnimal(eagle2);
        roomEarth.addAnimal(tiger3);


        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Pawtropolis!");
        System.out.println("What do want to do next? ");
        System.out.println("Type go to change the room");
        System.out.println("Type look to see what's inside the room ");
        System.out.println("Type bag to view  what's inside the bag");
        System.out.println("Type Exit to end your journey");
        System.out.print(" -> ");

        do {
            playerInput = scanner.next().toLowerCase();

            switch (playerInput) {
                case "go":
                    goRoom();
                    break;
                case "look":
                    lookRoom();
                    break;
                case "bag":
                    viewBag();
                    break;
                case "get":
                    getItem();
                    break;
                case "drop":
                    dropItem();
                    break;
                case "exit":
                    System.out.println("Pawtropolis hopes to see you again!");
                    break;
                default:
                    System.out.println("Invalid Input, try again");
            }
        } while (!playerInput.equalsIgnoreCase("EXIT" ));
    }


    private void goRoom() {
        System.out.println("Available directions: " + String.join(", ", player.getCurrentRoom().getAdjacents().keySet()));
        System.out.print("Choose a direction: ");
        String directionInput = scanner.nextLine().toLowerCase();

        if (player.getCurrentRoom().getAdjacents().containsKey(directionInput)) {
            Room nextRoom = player.getCurrentRoom().getAdjacents().get(directionInput);
            player.setCurrentRoom(nextRoom);
            System.out.println("You have entered  " + nextRoom.getRoomName());
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

    private void getItem() {
        System.out.print("Enter the item name to pick it up: ");
        String itemName = scanner.nextLine();
        player.pickItem(itemName);
    }

    private void dropItem() {
        System.out.print("Enter the item name to drop it: ");
        String itemName = scanner.nextLine();
        player.dropItem(itemName);
    }


}
