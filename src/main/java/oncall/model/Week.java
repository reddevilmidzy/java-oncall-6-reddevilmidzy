package oncall.model;

public enum Week {

    WEEKDAY("평일"),
    HOLIDAY("휴일"),
    ;

    private final String value;

    Week(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
