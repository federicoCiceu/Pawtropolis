package pawtropolis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pawtropolis.game.gamecontroller.GameFactory;
import pawtropolis.game.model.Player;
import pawtropolis.game.gamecontroller.VideoGameController;

@RestController
@RequestMapping("/api")
public class GameController {

    @GetMapping("/startGame")
    public String startGame() {
        Player player = new Player("Alex", 100);
        VideoGameController videoGameController = new VideoGameController(player);
        GameFactory populateGame = new GameFactory(player);
        populateGame.gamePopulation();
        videoGameController.commandAssignment(populateGame);
        //videoGameController.startGame();
        return "Ciao";
    }
}