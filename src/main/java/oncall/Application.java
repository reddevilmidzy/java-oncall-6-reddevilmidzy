package oncall;

import oncall.controller.InputController;
import oncall.controller.OnCallController;
import oncall.view.InputView;
import oncall.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        InputController inputController = new InputController(inputView, outputView);
        OnCallController onCallController = new OnCallController(inputController, outputView);
        onCallController.run();
    }
}
