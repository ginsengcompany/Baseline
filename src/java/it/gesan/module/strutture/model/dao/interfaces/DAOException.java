package it.gesan.module.strutture.model.dao.interfaces;

public class DAOException extends Exception {
    public DAOException() {
        super();
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(Throwable exception) {
        super(exception);
    }

    public DAOException(String message, Throwable exception) {
        super(message, exception);
    }
}
