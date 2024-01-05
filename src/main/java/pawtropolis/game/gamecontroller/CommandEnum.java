package pawtropolis.game.gamecontroller;

public enum CommandEnum {
    GO("go"),
    GET("get"),
    DROP("drop"),
    BAG("bag"),
    LOOK("look"),
    EXIT("exit");

    private final String name;

    CommandEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
