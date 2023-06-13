package homework.hw3.exceptions;

import java.io.IOException;

public class CloseException extends IOException {
    public CloseException(String message, Exception e) {
        super(message, e);
    }
}
