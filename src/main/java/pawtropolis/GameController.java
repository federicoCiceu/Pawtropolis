package pawtropolis;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pawtropolis.game.model.Player;
import pawtropolis.game.gamecontroller.VideoGameController;

@Configuration
public class GameController {
    @Bean
    public CommandLineRunner startGame() {
        return args -> {
            Player player = new Player("Alex", 100);
            VideoGameController videoGameController = new VideoGameController(player);
            VideoGameController populateGame = new VideoGameController(player);
            populateGame.gamePopulation();
            videoGameController.commandAssignment(populateGame);
            videoGameController.startGame();

        };
    }
}