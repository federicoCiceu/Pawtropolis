package pawtropolis.game.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Data
public class Door {
    private boolean locked;
    private final Item key;

    public void unlock() {
        locked = false;
    }

}