package oncall.model;

import java.util.Arrays;
import java.util.List;
import oncall.constant.ErrorMessage;

public class WorkingMonth {

    public static final int MONTH_INDEX = 0;
    public static final int DAY_INDEX = 1;

    private final int month;
    private final Day startDay;

    private WorkingMonth(int month, Day startDay) {
        this.month = month;
        this.startDay = startDay;
    }

    public static WorkingMonth from(String value) {
        validateSeparator(value);
        List<String> target = Arrays.stream(value.split(",")).toList();
        int month = validateAndConvertMonth(target.get(MONTH_INDEX));
        Day day = Day.valueOfName(target.get(DAY_INDEX));
        return new WorkingMonth(month, day);
    }

    private static void validateSeparator(String value) {
        if (value.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_VAlUE.getMessage());
        }
        if (value.startsWith(",") || value.endsWith(",")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_VAlUE.getMessage());
        }
        if (value.contains(",,")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_VAlUE.getMessage());
        }
        if (!value.contains(",")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_VAlUE.getMessage());
        }
    }

    private static int validateAndConvertMonth(String value) {
        try {
            int month = Integer.parseInt(value);
            if (month < 1 || month > 12) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_VAlUE.getMessage());
            }
            return month;
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_VAlUE.getMessage());
        }
    }
}
