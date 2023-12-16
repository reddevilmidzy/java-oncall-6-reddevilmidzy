package oncall.model;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Employees {

    private static final String SEPARATOR = ",";
    private static final int MIN_WORKER_COUNT = 5;
    private static final int MAX_WORKER_COUNT = 35;

    private final List<Employee> workers;


    private Employees(List<Employee> workers) {
        validateSize(workers);
        validateDuplicate(workers);
        this.workers = workers;
    }

    private void validateDuplicate(List<Employee> workers) {
        if (Set.copyOf(workers).size() != workers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateSize(List<Employee> workers) {
        if (workers.size() < MIN_WORKER_COUNT || workers.size() > MAX_WORKER_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    public static Employees from(String value) {
        validateSeparator(value);
        List<Employee> result = Arrays.stream(value.split(","))
                .map(Employee::new)
                .toList();
        return new Employees(result);
    }

    private static void validateSeparator(String value) {
        if (value.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (value.startsWith(SEPARATOR) || value.endsWith(SEPARATOR)) {
            throw new IllegalArgumentException();
        }
        if (value.contains(SEPARATOR.repeat(2))) {
            throw new IllegalArgumentException();
        }
    }
}
