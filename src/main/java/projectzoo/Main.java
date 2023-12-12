package projectzoo;

import projectzoo.domain.Room;
import projectzoo.game.Player;
import projectzoo.gamecontroller.VideoGameController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Room currentRoom = VideoGameController.roomMonstadt;
        Player player = new Player("Alex", 100, currentRoom);

        VideoGameController videoGameController = new VideoGameController(player);
        videoGameController.startGame();
    }

}