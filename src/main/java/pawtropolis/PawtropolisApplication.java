package pawtropolis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@SpringBootApplication
@Import(GameController.class)
public class PawtropolisApplication {
    public static void main(String[] args) {SpringApplication.run(PawtropolisApplication.class, args);}

}

