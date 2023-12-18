package oncall.model;

import java.util.List;

public class Date {

    private static final List<Date> holidays;

    static {
        holidays = List.of(
                new Date(Month.JANUARY, 1),
                new Date(Month.MARCH, 1),
                new Date(Month.MAY, 5),
                new Date(Month.JUNE, 6),
                new Date(Month.AUGUST, 15),
                new Date(Month.OCTOBER, 3),
                new Date(Month.OCTOBER, 9),
                new Date(Month.DECEMBER, 25));
    }

    private final Month month;
    private final int date;
    private final Day day;
    private final boolean holiday;

    public Date(Month month, int date, Day day) {
        this.month = month;
        this.date = date;
        this.day = day;
        this.holiday = holidays.contains(new Date(month, date));
    }

    private Date(Month month, int date) {
        this.month = month;
        this.date = date;
        this.day = null;
        this.holiday = true;
    }

    public boolean isWeekend() {
        return day.equals(Day.SAT) || day.equals(Day.SUN);
    }

    public boolean isHoliday() {
        return holiday;
    }

    @Override
    public String toString() {
        if (holiday) {
            return month.getValue() + "월 " + date + "일 " + day.getName() + "(휴일)";
        }
        return month.getValue() + "월 " + date + "일 " + day.getName();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Date target)) {
            return false;
        }
        return month.equals(target.month) && date == target.date;
    }
}
