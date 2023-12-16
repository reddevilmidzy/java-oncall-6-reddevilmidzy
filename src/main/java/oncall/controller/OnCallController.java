package oncall.controller;

import java.util.List;
import oncall.model.Date;
import oncall.model.Employee;
import oncall.model.Employees;
import oncall.model.Week;
import oncall.model.WorkingMonth;
import oncall.repository.WorkerRepository;
import oncall.service.Assignment;
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
        List<Employees> workers = inputController.getWorkers();
        WorkerRepository workerRepository = new WorkerRepository();
        workerRepository.register(Week.WEEKDAY, workers.get(0));
        workerRepository.register(Week.HOLIDAY, workers.get(1));
        Assignment assignment = new Assignment(0, 0);
        List<Employee> assign = assignment.assign(workingMonth, workerRepository);
        List<Date> monthDate = workingMonth.getMonthDate();

    }
}
