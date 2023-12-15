package projectzoo;

import projectzoo.game.Room;
import projectzoo.game.Player;
import projectzoo.game.gamecontroller.VideoGameController;


public class Main {
    public static void main(String[] args) {

        Room currentRoom = VideoGameController.roomMonstadt;
        Player player = new Player("Alex", 100, currentRoom);

        VideoGameController videoGameController = new VideoGameController(player);
        videoGameController.startGame();
    }

}