package projectzoo.gamecontroller;


import projectzoo.animals.Eagle;
import projectzoo.animals.Lion;
import projectzoo.animals.Tiger;
import projectzoo.domain.Room;
import projectzoo.game.Bag;
import projectzoo.game.Item;
import projectzoo.game.Player;

import java.time.LocalDate;
import java.util.*;

public class VideoGameController {
    private final Player player;
    private final static String NORTH = "north";
    private final static String SOUTH = "south";
    private final static String WEST = "west";
    private final static String EAST = "east";
    private final Bag bag1;
    private final Scanner scanner;

    public static Room roomHell = new Room("Hell");
    public Room roomParadise = new Room("Paradise");
    public Room roomForest = new Room("Forest");
    public Room roomCave = new Room("Cave");


    public VideoGameController(Player player, Room roomHell, Bag bag1, Scanner scanner) {
        this.player = player;
        this.roomHell = roomHell;
        this.bag1 = bag1;
        this.scanner = scanner;
    }


// Create Items
    Item item1 = new Item("tail", "wags", 8);
    Item item2 = new Item("front paws", " Pair them up with the rear paws to get a smile from a dog", 10);
    Item item3 = new Item("rear paws", "Pair them up with the front paws to get a smile from a dog", 10);
    Item item4 = new Item("snout", "sniffs objects", 31);

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
        Bag initialBag = bag1;

// Connect Rooms
        roomHell.addAdjacents(NORTH, roomParadise);
        roomParadise.addAdjacents(SOUTH, roomHell);
        roomParadise.addAdjacents(EAST, roomForest);
        roomForest.addAdjacents(WEST, roomParadise);
        roomForest.addAdjacents(EAST, roomCave);
        roomCave.addAdjacents(WEST, roomForest);


// Add Items to Rooms
        roomHell.addItem(item1);
        roomParadise.addItem(item2);
        roomForest.addItem(item3);
        bag1.addItem("snout");

// Add NPCs to Rooms
        roomHell.addAnimal(lion1);
        roomHell.addAnimal(lion2);
        roomParadise.addAnimal(tiger1);
        roomParadise.addAnimal(tiger2);
        roomCave.addAnimal(eagle1);
        roomCave.addAnimal(eagle3);


        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome!");
        System.out.println("What do want to do next ? ");
        System.out.println("Type go to change the room");
        System.out.println("Type look to see what's inside the room ");
        System.out.println("Type bag to view  what's inside the bag");
        System.out.println("Type Exit to end the game");
        System.out.print(" -> ");

        do {
            playerInput = scanner.nextLine();

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
                    System.out.println("You're out of the game");
                    break;
                default:
                    System.out.println("Invalid Input, try again");
            }
        } while (!playerInput.equalsIgnoreCase("exit"));
    }


    private void goRoom() {
        System.out.println("Available directions: " + String.join(", ", player.getCurrentRoom().getAdjacents().keySet()));
        System.out.print("Choose a direction: ");
        String directionInput = scanner.nextLine().toLowerCase();

        if (player.getCurrentRoom().getAdjacents().containsKey(directionInput)) {
            Room nextRoom = player.getCurrentRoom().getAdjacents().get(directionInput);
            player.setCurrentRoom(nextRoom);
            System.out.println("You have moved to the " + nextRoom.getRoomName());
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
        System.out.print("Enter the item name to pick up: ");
        String itemName = scanner.nextLine();
        player.pickItem(itemName);
    }

    private void dropItem() {
        System.out.print("Enter the item name to drop: ");
        String itemName = scanner.nextLine();
        player.dropItem(itemName);
    }


}
