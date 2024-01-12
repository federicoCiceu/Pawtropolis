package pawtropolis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pawtropolis.game.model.Player;
import pawtropolis.game.gamecontroller.VideoGameController;

@Configuration
public class GameController {
    private final Player player;
    private final VideoGameController videoGameController;

    @Bean
    public CommandLineRunner startGame() {
        return args -> {
            player.setLifePoints(100);
            player.setName("Yoimiya");

            videoGameController.populateGame();
            videoGameController.startGame();
        };
    }

    @Autowired
    public GameController(Player player, VideoGameController videoGameController) {
        this.player = player;
        this.videoGameController = videoGameController;
    }


}