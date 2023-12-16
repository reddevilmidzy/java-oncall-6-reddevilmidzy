package oncall.controller;

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

    public Employees getWeekdayEmployees() {
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

    public Employees getHolidayEmployees() {
        while (true) {
            try {
                return readHolidayEmployees();
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception);
            }
        }
    }

    private Employees readHolidayEmployees() {
        String value = inputView.readHolidayEmergencyWorker();
        return Employees.from(value);
    }
}
