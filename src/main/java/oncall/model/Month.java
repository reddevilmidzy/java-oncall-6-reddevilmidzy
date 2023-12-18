package oncall.model;

import java.util.Arrays;
import oncall.constant.ErrorMessage;

public enum Month {
    JANUARY("1", 31),
    FEBRUARY("2", 28),
    MARCH("3", 31),
    APRIL("4", 30),
    MAY("5", 31),
    JUNE("6", 30),
    JULY("7", 31),
    AUGUST("8", 31),
    SEPTEMBER("9", 30),
    OCTOBER("10", 31),
    NOVEMBER("11", 30),
    DECEMBER("12", 31);

    private final String value;
    private final int lastDay;

    Month(String value, int lastDay) {
        this.value = value;
        this.lastDay = lastDay;
    }

    public static Month valueOfName(String name) {
        return Arrays.stream(values())
                .filter(s -> s.value.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_VAlUE.getMessage()));
    }

    public int getLastDay() {
        return lastDay;
    }

    public String getValue() {
        return value;
    }
}
