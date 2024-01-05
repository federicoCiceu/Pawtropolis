package pawtropolis.game.gamecontroller;

public enum CommandEnum {
    GO("go"),
    GET("get"),
    DROP("drop"),
    BAG("bag"),
    LOOK("look"),
    EXIT("exit");

<<<<<<< Updated upstream
    private final String name;
=======
<<<<<<< HEAD
    private final String name;
=======
    //INVALID COMMAND PER CONTROLLARE LE ECCEZIONI

    private final String command;
>>>>>>> 0d3b65e33ef15664575f9f715fa73b5692c7f0ec
>>>>>>> Stashed changes

    CommandEnum(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
