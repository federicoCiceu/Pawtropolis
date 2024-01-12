package pawtropolis.game.gamecontroller;

import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Getter
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

    public static DirectionEnum getOppositeDirection(DirectionEnum direction){
        return switch (direction){
        case NORTH -> SOUTH;
        case EAST -> WEST;
        case WEST -> EAST;
        case SOUTH -> NORTH;
        };
    }


}
