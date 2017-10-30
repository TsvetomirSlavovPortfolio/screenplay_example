package abilities;

public class ActorCannotCallAnApiException extends RuntimeException {
    public ActorCannotCallAnApiException(String message) {
        super(message);
    }
}
