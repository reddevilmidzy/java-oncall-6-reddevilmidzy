package oncall.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class EmployeesTest {

    @ParameterizedTest
    @ValueSource(strings = {"동글,우코,글로,루루", "동글,앙마", "믿지"})
    @DisplayName("근무자가 최소 5가 되지 않으면 예외 발생")
    void createMinWorker(String value) {

        assertThatThrownBy(() -> Employees.from(value))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @ParameterizedTest
    @ValueSource(strings = {
            "준팍,도밥,수아,루루,글로,솔로스타,우코,슬링키,참새,도리,고니,준팍1,도밥1,수아1,루루1,글로1,솔스타1,우코1,슬링키1,참새1,도리1,고니1,준팍2,도밥2,수아2,루루2,글로2,솔타2,우코2,슬링키2,참새2,도리2,고니2,동글,앙마,믿지,있지,날자"})
    @DisplayName("근무자가 35 넘으면 예외 발생")
    void createMaxWorker(String value) {

        assertThatThrownBy(() -> Employees.from(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"동글,앙마,믿지,앙마,있지"})
    @DisplayName("중복된 닉네임 예외")
    void createDuplicate(String value) {
        assertThatThrownBy(() -> Employees.from(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("equal 확인")
    void createCheckEqual() {
        Employees a = Employees.from("동글,앙마,있지,믿지,날자");
        Employees b = Employees.from("있지,동글,믿지,앙마,날자");
        Employees c = Employees.from("있지,동글,믿지,앙마,행복");

        boolean equals = a.equals(b);
        assertThat(equals).isTrue();
        assertThat(b.equals(c)).isFalse();
    }
}
