package oncall.model;

import java.util.Arrays;

public enum Day {

    SUN("일"),
    MON("월"),
    TUE("화"),
    WEN("수"),
    THU("목"),
    FRI("금"),
    SAT("토");

    private final String name;

    Day(String name) {
        this.name = name;
    }

    public static Day valueOfName(String name) {
        return Arrays.stream(values())
                .filter(s -> s.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public String getName() {
        return name;
    }
}
