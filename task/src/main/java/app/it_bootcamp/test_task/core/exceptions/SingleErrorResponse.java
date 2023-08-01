package app.it_bootcamp.test_task.core.exceptions;

public class SingleErrorResponse {

    private String logref;
    private String message;

    public SingleErrorResponse(String logref, String message) {
        this.logref = logref;
        this.message = message;
    }

    public SingleErrorResponse() {

    }

    public String getLogref() {
        return logref;
    }

    public void setLogref(String logref) {
        this.logref = logref;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
