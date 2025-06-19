

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private static Logger instance;

    private Logger() {
        System.out.println("Logger instance created at: " + getCurrentTimestamp());
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[" + getCurrentTimestamp() + "] LOG: " + message);
    }

    public void logError(String errorMessage) {
        System.err.println("[" + getCurrentTimestamp() + "] ERROR: " + errorMessage);
    }

    public void logWarning(String warningMessage) {
        System.out.println("[" + getCurrentTimestamp() + "] WARNING: " + warningMessage);
    }

    public void logInfo(String infoMessage) {
        System.out.println("[" + getCurrentTimestamp() + "] INFO: " + infoMessage);
    }

    private String getCurrentTimestamp() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public String getInstanceDetails() {
        return "Logger instance: " + this.hashCode();
    }
}