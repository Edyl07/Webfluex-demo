package tech.edyl.webfluxdemo.dto;

public class InputFailedValidationResponse {
    private int errorCode;
    private  int input;
    private String message;

    public int getErrorCode() {
        return errorCode;
    }

    public int getInput() {
        return input;
    }

    public String getMessage() {
        return message;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public void setInput(int input) {
        this.input = input;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
