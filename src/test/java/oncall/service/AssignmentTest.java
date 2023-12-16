package oncall.service;

import java.util.List;
import oncall.model.Employee;
import oncall.model.Employees;
import oncall.model.Week;
import oncall.model.WorkingMonth;
import oncall.repository.WorkerRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AssignmentTest {

    @Test
    @DisplayName("중복 상관 없이 우선 확인")
    void createNormal() {
        //given
        Assignment assignment = new Assignment(0, 0);
        WorkingMonth from = WorkingMonth.from("5,월");

        WorkerRepository workerRepository = new WorkerRepository();
        workerRepository.register(Week.HOLIDAY, Employees.from("동글,앙마,있지,믿지,날자"));
        workerRepository.register(Week.WEEKDAY, Employees.from("있지,동글,믿지,앙마,날자"));

        //when
        List<Employee> assign = assignment.assign(from, workerRepository);

        //then
        System.out.println(assign);
    }

}