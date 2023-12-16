package oncall.view;

import oncall.constant.ErrorMessage;

public class OutputView {

    public static final String ERROR_FORM = "[ERROR] %s %s%n";

    public void printErrorMessage(Throwable throwable) {
        System.out.printf(ERROR_FORM, throwable.getMessage(), ErrorMessage.RETRY_INPUT.getMessage());
    }

}
