package pawtropolis.game.gamecontroller;

public enum CommandEnum {
    GO("go"),
    GET("get"),
    DROP("drop"),
    BAG("bag"),
    LOOK("look"),
    EXIT("exit");

    //INVALID COMMAND PER CONTROLLARE LE ECCEZIONI

    private final String name;

    CommandEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
