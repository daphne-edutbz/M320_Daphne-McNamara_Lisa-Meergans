package tbz.ch;

public class PlaylistEmptyException extends RuntimeException {
    public PlaylistEmptyException(String message) {
        super(message);
    }
}
