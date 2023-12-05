package projectzoo.gamecontroller;


import projectzoo.animals.Lion;
import projectzoo.domain.Room;
import projectzoo.game.Bag;
import projectzoo.game.Item;
import projectzoo.game.Player;

import java.time.LocalDate;
import java.util.Scanner;

public class VideoGameController {
    private final Player player1;
    private final Room room1;
    private final Bag bag1;


    public VideoGameController(Player player1, Room room1, Bag bag1) {
        this.player1 = player1;
        this.room1 = room1;
        this.bag1 = bag1;
    }

    Item item1 = new Item("tail", "wags", 8);
    Item item2 = new Item("front paws", " Pair them up with the rear paws to get a smile from a dog", 10);
    Lion lion2 = new Lion("Leo", "Chicken", 8, LocalDate.of(2015, 4, 10), 1.09, 1.17, 36);
    Lion lion3 = new Lion("Rin", "Pork", 10, LocalDate.of(2013, 12, 5), 2.80, 1.20, 55);

    public void startGame() {
        Room currentRoom = room1;
        String playerInput;
        Bag initialBag = bag1;
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

                    break;
                case "look":
                    currentRoom.lookRoom();
                    break;
                case "bag":
                    initialBag.viewBag();
                    break;
                case "get":
                    initialBag.addItem("frontpaws", "afafadg", 10);
                    currentRoom.addAnimal(lion2);
                    currentRoom.addItem(item2);
                    break;
                case "drop ":

                    break;
                case " exit ":

                    break;
                default:
                    System.out.println("Invalid Input, try again");
            }
        }while (!playerInput.equalsIgnoreCase("exit"));




    }


}
