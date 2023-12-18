package oncall.model;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WorkingMonthTest {


    @Test
    @DisplayName("달 정보 확인")
    void createMonthDate() {
        //given
        String value = "5,월";
        WorkingMonth workingMonth = WorkingMonth.from(value);

        //when
        List<Date> monthDate = workingMonth.getMonthDate();

        //then
        for (Date date : monthDate) {
            System.out.println(date.toString());
        }
    }

}