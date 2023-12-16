package oncall.model;

import java.util.Arrays;
import oncall.constant.ErrorMessage;

public enum Day {

    SUN(0, "일"),
    MON(1, "월"),
    TUE(2, "화"),
    WEN(3, "수"),
    THU(4, "목"),
    FRI(5, "금"),
    SAT(6, "토");

    private final int index;
    private final String name;

    Day(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public static Day valueOfName(String name) {
        return Arrays.stream(values())
                .filter(s -> s.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_VAlUE.getMessage()));
    }

    public String getName() {
        return name;
    }

    public Day calculateDay(int addDate) {
        int current = (index + addDate - 1) % 7;
        return Arrays.stream(values())
                .filter(s -> s.index == current)
                .findFirst()
                .orElseThrow();
    }
}
