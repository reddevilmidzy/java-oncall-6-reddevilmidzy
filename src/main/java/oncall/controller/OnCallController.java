package oncall.controller;

import oncall.model.Employees;
import oncall.model.WorkingMonth;
import oncall.view.OutputView;

public class OnCallController {

    private final InputController inputController;
    private final OutputView outputView;


    public OnCallController(InputController inputController, OutputView outputView) {
        this.inputController = inputController;
        this.outputView = outputView;
    }

    public void run() {
        WorkingMonth workingMonth = inputController.getWorkingMonth();
        Employees weekDayEmployees = inputController.getEmployees();

    }
}
