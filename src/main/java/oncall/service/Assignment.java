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
    private boolean weekdayDuplicate = false;
    private boolean holidayDuplicate = false;

    public Assignment(int weekdayIndex, int holidayIndex) {
        this.weekdayIndex = weekdayIndex;
        this.holidayIndex = holidayIndex;
    }

    public List<Employee> assign(WorkingMonth month, WorkerRepository repository) {
        List<Date> dates = month.getMonthDate();
        Iterator<Date> iterator = dates.iterator();
        Employees weekday = repository.getEmployees(Week.WEEKDAY);
        System.out.println("weekday = " + weekday);
        Employees holiday = repository.getEmployees(Week.HOLIDAY);
        System.out.println("holiday = " + holiday);

        List<Employee> result = new ArrayList<>();

        Employee preWorker = null;

        while (iterator.hasNext()) {
            Date date = iterator.next();
            Employee holidayWorker = holiday.get(holidayIndex);
            Employee weekdayWorker = weekday.get(weekdayIndex);

            if (date.isHoliday() || date.isWeekend()) {
                if (holidayWorker.equals(preWorker)) {
                    Employee nextEmployee = holiday.get(holidayIndex + 1);
                    result.add(nextEmployee);
                    holidayDuplicate = true;
                    continue;
                } else if (holidayDuplicate) {
                    result.add(holidayWorker);
                    holidayIndex += 2;
                    holidayDuplicate = false;
                    continue;
                }
                result.add(holidayWorker);
                preWorker = holidayWorker;
                holidayIndex++;
                continue;
            }

            if (weekdayWorker.equals(preWorker)) {
                Employee nextEmployee = weekday.get(weekdayIndex + 1);
                result.add(nextEmployee);
                weekdayDuplicate = true;
                continue;
            } else if (weekdayDuplicate) {
                result.add(weekdayWorker);
                weekdayIndex += 2;
                weekdayDuplicate = false;
                continue;
            }
            result.add(weekdayWorker);
            preWorker = weekdayWorker;
            weekdayIndex++;
        }

        return result;
    }
}
