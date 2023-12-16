package oncall.controller;

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
                return readXX();
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception);
            }
        }
    }

    private WorkingMonth readXX() {
        String value = inputView.readAssignmentMonth();
        return WorkingMonth.from(value);
    }

}
