package pawtropolis.game.commands;

import java.util.Arrays;

public enum DirectionEnum {
    NORTH ("north"),
    SOUTH ("south"),
    EAST ("east"),
    WEST("west");

    private final String name;

    DirectionEnum(String name) {
        this.name = name;
    }

    public static DirectionEnum parseDirection(String input){
        return Arrays.stream(DirectionEnum.values())
                .filter(c -> c.name.equalsIgnoreCase(input))
                .findFirst()
                .orElse(null);
    }

    public String getName() {
        return name;
    }
}
