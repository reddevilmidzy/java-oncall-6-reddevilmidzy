package oncall.repository;

import java.util.HashMap;
import java.util.Map;
import oncall.model.Employees;
import oncall.model.Week;

public class WorkerRepository {

    private Map<Week, Employees> repository;

    public WorkerRepository() {
        this.repository = new HashMap<>();
    }

    public void register(Week week, Employees employees) {
        repository.put(week, employees);
    }

    public Employees getEmployees(Week week) {
        return repository.get(week);
    }
}
