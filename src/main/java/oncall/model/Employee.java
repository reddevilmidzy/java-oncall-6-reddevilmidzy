package oncall.model;

import java.util.Objects;
import oncall.constant.ErrorMessage;

public class Employee {


    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Employee(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_VAlUE.getMessage());
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_VAlUE.getMessage());
        }
        //TODO: 이름에 특수문자 포함되지 않게 하기
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Employee target)) {
            return false;
        }
        return name.equals(target.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
