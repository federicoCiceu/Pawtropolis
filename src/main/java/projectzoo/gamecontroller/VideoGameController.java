package projectzoo.gamecontroller;


import projectzoo.animals.Eagle;
import projectzoo.animals.Lion;
import projectzoo.animals.Tiger;
import projectzoo.domain.Room;
import projectzoo.game.Bag;
import projectzoo.game.Item;
import projectzoo.game.Player;

import java.time.LocalDate;
import java.util.Scanner;

public class VideoGameController {
    private final Player player;
    private final Room room1;
    private final Room room2;
    private final Room room3;
    private final Bag bag1;


    public VideoGameController(Player player, Room room1, Room room2, Room room3, Bag bag1) {
        this.player = player;
        this.room1 = room1;
        this.room2 = room2;
        this.room3 = room3;
        this.bag1 = bag1;
    }

        Item item1 = new Item("tail", "wags", 8);
        Item item2 = new Item("front paws", " Pair them up with the rear paws to get a smile from a dog", 10);
        Item item3 = new Item("rear paws", "Pair them up with the front paws to get a smile from a dog", 10);
        Item item4 = new Item("snout", "sniffs objects", 31);

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
        Room currentRoom1 = room1;
        Room currentRoom2 = room2;
        Room currentRoom3 = room3;
        String playerInput;
        Bag initialBag = bag1;

        initialBag.addItem("rear paws");
        currentRoom1.addItem(item1);
        currentRoom1.addItem(item2);
        currentRoom1.addAnimal(lion2);
        currentRoom2.addAnimal(lion1);
        currentRoom2.addAnimal(lion2);
        currentRoom1.addAdjacents("nord",currentRoom2);
        currentRoom2.addAdjacents("sud",currentRoom1);
        currentRoom2.addAdjacents("nord",currentRoom3);
        currentRoom3.addAdjacents("sud",currentRoom2);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome!");
        room1.lookRoom();
        do {
            System.out.println("What do want to do next ? ");
            System.out.println("Type go to change the room");
            System.out.println("Type look to see what's inside the room ");
            System.out.println("Type bag to view  what's inside the bag");
            System.out.println("Type Exit to end the game");
            System.out.print(" -> ");

        playerInput = scanner.nextLine();

            switch (playerInput) {
                case "go":
                    currentRoom1.getAdjacents("nord");
                    break;
                case "look":
                    currentRoom1.lookRoom();
                    break;
                case "bag":
                    initialBag.viewBag();
                    break;
                case "get":
                    initialBag.addItem("front paws");
                    break;
                case "drop":
                    initialBag.dropItem("front paws");
                    break;
                case "exit":
                    System.out.println("You're out of the game");
                    break;
                default:
                    System.out.println("Invalid Input, try again");
            }
        }while (!playerInput.equalsIgnoreCase("exit"));

            }
}
