package app.it_bootcamp.test_task.core.exceptions;

public class ErrorObject {

    private final String message;
    private final String field;

    public ErrorObject(String message, String field) {
        this.message = message;
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public String getField() {
        return field;
    }
}
