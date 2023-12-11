package projectzoo;

import projectzoo.domain.Room;
import projectzoo.game.Player;
import projectzoo.gamecontroller.VideoGameController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Room currentRoom = VideoGameController.roomHell;
        Player player = new Player("Alex", 100, currentRoom);

        VideoGameController videoGameController = new VideoGameController(player, scanner);
        videoGameController.startGame();
    }

}