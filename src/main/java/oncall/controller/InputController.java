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

    public Employees getEmployees() {
        while (true) {
            try {
                return readEmployees();
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception);
            }
        }
    }


    private Employees readEmployees() {
        String value = inputView.readWeekdayEmergencyWorker();
        return Employees.from(value);
    }
}
