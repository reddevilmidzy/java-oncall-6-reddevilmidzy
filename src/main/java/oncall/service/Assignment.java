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
                    preWorker = assignWorker(result, holiday.get(holidayIndex), holiday.get(holidayIndex - 1));
                    continue;
                } else if (dayOffWorker != null) {
                    preWorker = assignWorker(result, dayOffWorker, dayOffWorker);
                    dayOffWorker = null;
                    continue;
                }
                preWorker = assignWorker(result, holidayWorker, holidayWorker);
                continue;
            }
            weekdayIndex += 1;
            if (weekdayWorker.equals(preWorker)) {
                dayOffWorker = weekdayWorker;
                preWorker = assignWorker(result, weekday.get(weekdayIndex), weekday.get(weekdayIndex - 1));
                continue;
            } else if (dayOffWorker != null) {
                preWorker = assignWorker(result, dayOffWorker, dayOffWorker);
                dayOffWorker = null;
                continue;
            }
            preWorker = assignWorker(result, weekdayWorker, weekdayWorker);
        }
        return result;
    }

    private Employee assignWorker(List<Employee> result, Employee currentWorker, Employee preWorker) {
        result.add(currentWorker);
        return preWorker;
    }
}
