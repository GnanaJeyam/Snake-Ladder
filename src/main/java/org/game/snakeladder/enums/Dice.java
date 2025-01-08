package org.game.snakeladder.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Dice {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6);

    private final int side;

    Dice(int side) {
        this.side = side;
    }

    private static Map<Integer, Dice> cache;
    static {
        cache = Arrays.stream(Dice.values()).collect(Collectors.toMap(Dice::getSide, Function.identity()));
    }

    public int getSide() {
        return side;
    }

    public static Dice retrieveSide(int side) {
        return cache.get(side);
    }
}
