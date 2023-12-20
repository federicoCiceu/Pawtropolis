package pawtropolis;

import pawtropolis.game.Room;
import pawtropolis.game.Player;
import pawtropolis.game.gamecontroller.VideoGameController;


public class Main {
    public static void main(String[] args) {

        Player player = new Player("Alex", 100);

        VideoGameController videoGameController = new VideoGameController(player);
        videoGameController.populateGame();
        videoGameController.startGame();
    }

}