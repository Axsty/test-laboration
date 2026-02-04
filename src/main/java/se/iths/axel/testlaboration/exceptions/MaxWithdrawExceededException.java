package se.iths.axel.testlaboration.exceptions;

public class MaxWithdrawExceededException extends RuntimeException {

    public MaxWithdrawExceededException(String message) {
        super(message);
    }
}
