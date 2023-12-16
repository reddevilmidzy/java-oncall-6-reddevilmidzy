package oncall.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import oncall.model.Date;
import oncall.model.Employee;
import oncall.model.Employees;
import oncall.model.Week;
import oncall.model.WorkingMonth;
import oncall.repository.WorkerRepository;

public class Assignment {

    private int weekdayIndex;
    private int holidayIndex;

    public Assignment(int weekdayIndex, int holidayIndex) {
        this.weekdayIndex = weekdayIndex;
        this.holidayIndex = holidayIndex;
    }

    public List<Employee> assign(WorkingMonth month, WorkerRepository repository) {
        List<Date> dates = month.getMonthDate();
        Iterator<Date> iterator = dates.iterator();
        Employees weekday = repository.getEmployees(Week.WEEKDAY);
        Employees holiday = repository.getEmployees(Week.HOLIDAY);

        List<Employee> result = new ArrayList<>();

        Employee preWorker = null;
        Employee dayOffWorker = null;

        while (iterator.hasNext()) {
            Date date = iterator.next();
            Employee holidayWorker = holiday.get(holidayIndex);
            Employee weekdayWorker = weekday.get(weekdayIndex);

            if (date.isHoliday() || date.isWeekend()) {
                holidayIndex += 1;
                if (holidayWorker.equals(preWorker)) {
                    dayOffWorker = holidayWorker;
                    result.add(holiday.get(holidayIndex));
                    preWorker = holiday.get(holidayIndex - 1);
                    continue;
                } else if (dayOffWorker != null) {
                    result.add(dayOffWorker);
                    preWorker = dayOffWorker;
                    dayOffWorker = null;
                    continue;
                }
                result.add(holidayWorker);
                preWorker = holidayWorker;
                continue;
            }
            weekdayIndex += 1;
            if (weekdayWorker.equals(preWorker)) {
                dayOffWorker = weekdayWorker;
                result.add(weekday.get(weekdayIndex));
                preWorker = weekday.get(weekdayIndex - 1);
                continue;
            } else if (dayOffWorker != null) {
                result.add(dayOffWorker);
                preWorker = dayOffWorker;
                dayOffWorker = null;
                continue;
            }
            result.add(weekdayWorker);
            preWorker = weekdayWorker;
        }
        return result;
    }
}
