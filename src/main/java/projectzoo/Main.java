package projectzoo;

import projectzoo.domain.Room;
import projectzoo.game.Bag;
import projectzoo.game.Player;
import projectzoo.gamecontroller.VideoGameController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Room currentRoom = VideoGameController.roomHell;
        Player player = new Player("Alex", 100, currentRoom);
        Bag bag1 = new Bag(30);

        VideoGameController videoGameController = new VideoGameController(player, currentRoom, bag1, scanner);
        videoGameController.startGame();

    }


}