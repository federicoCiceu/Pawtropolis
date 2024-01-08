package pawtropolis.game.gamecontroller;

import lombok.Getter;

@Getter
public enum CommandEnum {
    GO("go"),
    GET("get"),
    DROP("drop"),
    BAG("bag"),
    LOOK("look"),
    EXIT("exit");

    //INVALID COMMAND PER CONTROLLARE LE ECCEZIONI

    private final String command;

    CommandEnum(String command) {
        this.command = command;
    }

}
