package pe.cibertec;

public class ErrorResponseMessage {
    private String error;

    public ErrorResponseMessage(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}