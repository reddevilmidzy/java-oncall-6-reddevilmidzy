package oncall.view;

import java.util.List;
import oncall.constant.ErrorMessage;
import oncall.model.Date;
import oncall.model.Employee;

public class OutputView {

    public static final String ERROR_FORM = "[ERROR] %s %s%n";

    public void printErrorMessage(Throwable throwable) {
        System.out.printf(ERROR_FORM, throwable.getMessage(), ErrorMessage.RETRY_INPUT.getMessage());
    }

    public void printAssignResult(List<Date> dates, List<Employee> employees) {
        for (int i = 0; i < dates.size(); i++) {
            System.out.printf("%s %s%n", dates.get(i), employees.get(i));
        }
    }

}
