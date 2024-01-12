package pawtropolis.game.gamecontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import pawtropolis.game.model.Player;
import pawtropolis.game.gamecontroller.VideoGameController;

@Component
public class GameController {
    @Autowired
    private Player player;
    @Autowired
    private VideoGameController videoGameController;

    public void startGame() {
        player.setLifePoints(100);
        player.setName("Yoimiya");
        videoGameController.populateGame();
        videoGameController.startGame();
    }


}