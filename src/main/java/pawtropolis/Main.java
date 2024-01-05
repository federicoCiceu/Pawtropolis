package pawtropolis;

<<<<<<< Updated upstream
import pawtropolis.game.Room;
import pawtropolis.game.Player;
=======
import pawtropolis.game.gamecontroller.GameFactory;
import pawtropolis.game.model.Player;
>>>>>>> Stashed changes
import pawtropolis.game.gamecontroller.VideoGameController;


public class Main {
    public static void main(String[] args) {

        Room currentRoom = VideoGameController.roomMonstadt;
        Player player = new Player("Alex", 100, currentRoom);

        VideoGameController videoGameController = new VideoGameController(player);
<<<<<<< Updated upstream

=======
        GameFactory populateGame = new GameFactory(player);
        populateGame.gamePopulation();
        videoGameController.commandAssignment(populateGame);
>>>>>>> Stashed changes
        videoGameController.startGame();
    }

}