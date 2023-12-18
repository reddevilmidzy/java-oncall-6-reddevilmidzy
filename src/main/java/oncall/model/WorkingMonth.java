package oncall.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import oncall.constant.ErrorMessage;

public class WorkingMonth {

    private static final String SEPARATOR = ",";
    private static final int MONTH_INDEX = 0;
    private static final int DAY_INDEX = 1;

    private final Month month;
    private final Day startDay;

    private WorkingMonth(Month month, Day startDay) {
        this.month = month;
        this.startDay = startDay;
    }

    public static WorkingMonth from(String value) {
        validateSeparator(value);
        List<String> target = Arrays.stream(value.split(SEPARATOR)).toList();
        Month month = Month.valueOfName(target.get(MONTH_INDEX));
        Day day = Day.valueOfName(target.get(DAY_INDEX));
        return new WorkingMonth(month, day);
    }

    private static void validateSeparator(String value) {
        if (value.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_VAlUE.getMessage());
        }
        if (value.startsWith(SEPARATOR) || value.endsWith(SEPARATOR)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_VAlUE.getMessage());
        }
        if (value.contains(SEPARATOR.repeat(2))) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_VAlUE.getMessage());
        }
        if (!value.contains(SEPARATOR)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_VAlUE.getMessage());
        }
    }

    public List<Date> getMonthDate() {
        List<Date> result = new ArrayList<>();
        for (int date = 1; date <= month.getLastDay(); date++) {
            result.add(new Date(month, date, startDay.calculateDay(date)));
        }
        return result;
    }
}
