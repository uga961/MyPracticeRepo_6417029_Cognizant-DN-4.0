

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AdvancedLogger {

    private AdvancedLogger() {
        System.out.println("AdvancedLogger instance created at: " + getCurrentTimestamp());
    }

    private static class SingletonHelper {
        private static final AdvancedLogger INSTANCE = new AdvancedLogger();
    }

    public static AdvancedLogger getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public void log(String message) {
        System.out.println("[" + getCurrentTimestamp() + "] ADVANCED LOG: " + message);
    }

    public void logError(String errorMessage) {
        System.err.println("[" + getCurrentTimestamp() + "] ADVANCED ERROR: " + errorMessage);
    }

    public void logWarning(String warningMessage) {
        System.out.println("[" + getCurrentTimestamp() + "] ADVANCED WARNING: " + warningMessage);
    }

    public void logInfo(String infoMessage) {
        System.out.println("[" + getCurrentTimestamp() + "] ADVANCED INFO: " + infoMessage);
    }

    private String getCurrentTimestamp() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public String getInstanceDetails() {
        return "AdvancedLogger instance: " + this.hashCode();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cannot clone singleton instance");
    }
}