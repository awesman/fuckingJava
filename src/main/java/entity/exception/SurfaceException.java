package entity.exception;

public class SurfaceException extends Exception {

    private static final long serialVersionUID = 1L;

    public SurfaceException() {
        super();
    }

    public SurfaceException(String message) {
        super(message);
    }

    public SurfaceException(String message, Throwable cause) {
        super(message, cause);
    }

    public SurfaceException(Throwable cause) {
        super(cause);
    }

}
