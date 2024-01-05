package pawtropolis;

import pawtropolis.game.gamecontroller.GameFactory;
import pawtropolis.game.model.Player;
import pawtropolis.game.gamecontroller.VideoGameController;


public class Main {
    public static void main(String[] args) {

        Player player = new Player("Alex", 100);

        VideoGameController videoGameController = new VideoGameController(player);
        GameFactory populateGame = new GameFactory(player);
        populateGame.gamePopulation();
        videoGameController.commandAssignment(populateGame);
        videoGameController.startGame();
    }

}