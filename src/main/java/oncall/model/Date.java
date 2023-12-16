package oncall.model;

public class Date {

    private final Month month;
    private final int date;
    private final Day day;
    private final boolean holiday;

    public Date(Month month, int date, Day day) {
        this.month = month;
        this.date = date;
        this.day = day;
        this.holiday = checkHoliday(month, date);
    }


    //TODO: 리팩토링 대상
    private boolean checkHoliday(Month month, int date) {
        if (month.equals(Month.JANUARY) && date == 1) {
            return true;
        }
        if (month.equals(Month.MARCH) && date == 1) {
            return true;
        }
        if (month.equals(Month.MAY) && date == 5) {
            return true;
        }
        if (month.equals(Month.JUNE) && date == 6) {
            return true;
        }
        if (month.equals(Month.AUGUST) && date == 15) {
            return true;
        }
        if (month.equals(Month.OCTOBER) && date == 3) {
            return true;
        }
        if (month.equals(Month.OCTOBER) && date == 9) {
            return true;
        }
        return month.equals(Month.DECEMBER) && date == 25;
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
}
