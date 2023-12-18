package oncall.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EmployeeTest {

    @Test
    @DisplayName("이름 길이 5초과면 예외")
    void createInvalidName() {

        assertThatThrownBy(() -> new Employee("다섯글자초과"));

    }

}