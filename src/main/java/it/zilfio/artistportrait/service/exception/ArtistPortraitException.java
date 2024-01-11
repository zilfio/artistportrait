package it.zilfio.artistportrait.service.exception;

public class ArtistPortraitException extends Exception {

    public ArtistPortraitException() {
        super();
    }

    public ArtistPortraitException(String message) {
        super(message);
    }

    public ArtistPortraitException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArtistPortraitException(Throwable cause) {
        super(cause);
    }

    protected ArtistPortraitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
