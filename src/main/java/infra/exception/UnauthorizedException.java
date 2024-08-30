package infra.exception;

public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException() {
        super("UNAUTHORIZED");
    }
}
