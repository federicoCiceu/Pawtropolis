package pawtropolis;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pawtropolis.game.gamecontroller.GameController;
@RequiredArgsConstructor
@SpringBootApplication
public class PawtropolisApplication implements CommandLineRunner {
    private final GameController gameController;
    public static void main(String[] args) {SpringApplication.run(PawtropolisApplication.class, args);}

    @Override
    public void run(String... args) throws Exception {
        gameController.startGame();
        //System.exit(0);
    }
}
