package app.it_bootcamp.test_task.core.exceptions.handler;

import app.it_bootcamp.test_task.core.exceptions.ErrorObject;
import app.it_bootcamp.test_task.core.exceptions.MultipleErrorResponse;
import app.it_bootcamp.test_task.core.exceptions.SingleErrorResponse;
import jakarta.persistence.OptimisticLockException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerExceptionHandler {

    private static final String ERROR = "error";
    private static final String STRUCTURED_ERROR = "structured error";

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<MultipleErrorResponse> handleConstraintViolationException(MethodArgumentNotValidException e) {
        List<ErrorObject> errorsList = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        for (ObjectError error : e.getBindingResult().getAllErrors()) {
          errorsList.add(new ErrorObject(error.getDefaultMessage(), error.toString().split("'")[3]));
        }
        MultipleErrorResponse errorResponse = new MultipleErrorResponse(STRUCTURED_ERROR, errorsList);
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<List<SingleErrorResponse>> handleSQLException(
            RuntimeException ex) {
        SingleErrorResponse errorResponse = new SingleErrorResponse(ERROR, "Пользователь с такой почтой уже зарегистрирован");

        return ResponseEntity.badRequest().body(List.of(errorResponse));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<SingleErrorResponse> handleIllegalArgumentException(
            RuntimeException ex) {
        SingleErrorResponse errorResponse = new SingleErrorResponse(ERROR, ex.getMessage());
        return ResponseEntity.badRequest().body(errorResponse);
    }

}
