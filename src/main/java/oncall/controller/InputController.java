package oncall.controller;

import java.util.ArrayList;
import java.util.List;
import oncall.model.Employees;
import oncall.model.WorkingMonth;
import oncall.view.InputView;
import oncall.view.OutputView;

public class InputController {

    private final InputView inputView;
    private final OutputView outputView;


    public InputController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public WorkingMonth getWorkingMonth() {
        while (true) {
            try {
                return readWorkingMonth();
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception);
            }
        }
    }

    private WorkingMonth readWorkingMonth() {
        String value = inputView.readAssignmentMonth();
        return WorkingMonth.from(value);
    }

    public List<Employees> getWorkers() {
        while (true) {
            try {
                List<Employees> result = new ArrayList<>();
                result.add(getWeekdayEmployees());
                result.add(getHolidayEmployees());
                return result;
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception);
            }
        }
    }

    private Employees getWeekdayEmployees() {
        while (true) {
            try {
                return readWeekdayEmployees();
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception);
            }
        }
    }

    private Employees readWeekdayEmployees() {
        String value = inputView.readWeekdayEmergencyWorker();
        return Employees.from(value);
    }

    private Employees getHolidayEmployees() {
        return readHolidayEmployees();
    }

    private Employees readHolidayEmployees() {
        String value = inputView.readHolidayEmergencyWorker();
        return Employees.from(value);
    }
}
