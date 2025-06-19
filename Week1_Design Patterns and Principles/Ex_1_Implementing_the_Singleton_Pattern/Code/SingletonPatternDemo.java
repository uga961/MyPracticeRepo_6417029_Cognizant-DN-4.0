

public class SingletonPatternDemo {

    public static void main(String[] args) {
        System.out.println("SINGLETON PATTERN DEMONSTRATION");
        System.out.println("=" .repeat(60));

        demonstrateBasicSingleton();

        System.out.println("\n" + "=" .repeat(60) + "\n");

        demonstrateAdvancedSingleton();

        System.out.println("\n" + "=" .repeat(60) + "\n");

        demonstrateThreadSafety();
    }

    private static void demonstrateBasicSingleton() {
        System.out.println("DEMO 1: Basic Singleton Pattern (Synchronized)");
        System.out.println("-" .repeat(50));

        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        Logger logger3 = Logger.getInstance();

        System.out.println("Instance 1 Hash: " + logger1.hashCode());
        System.out.println("Instance 2 Hash: " + logger2.hashCode());
        System.out.println("Instance 3 Hash: " + logger3.hashCode());
        System.out.println("Are all instances equal? " + (logger1 == logger2 && logger2 == logger3));

        logger1.log("Testing basic singleton pattern");
        logger2.logInfo("This message comes from the same instance");
        logger3.logWarning("All loggers are actually the same object");
    }

    private static void demonstrateAdvancedSingleton() {
        System.out.println("DEMO 2: Advanced Singleton Pattern (Bill Pugh)");
        System.out.println("-" .repeat(50));

        AdvancedLogger advLogger1 = AdvancedLogger.getInstance();
        AdvancedLogger advLogger2 = AdvancedLogger.getInstance();
        AdvancedLogger advLogger3 = AdvancedLogger.getInstance();

        System.out.println("Advanced Instance 1 Hash: " + advLogger1.hashCode());
        System.out.println("Advanced Instance 2 Hash: " + advLogger2.hashCode());
        System.out.println("Advanced Instance 3 Hash: " + advLogger3.hashCode());
        System.out.println("Are all advanced instances equal? " + (advLogger1 == advLogger2 && advLogger2 == advLogger3));

        advLogger1.log("Testing advanced singleton pattern");
        advLogger2.logInfo("This is more efficient and thread-safe");
        advLogger3.logWarning("No synchronization overhead!");
    }

    private static void demonstrateThreadSafety() {
        System.out.println("DEMO 3: Thread Safety Test");
        System.out.println("-" .repeat(50));

        Thread thread1 = new Thread(() -> {
            Logger logger = Logger.getInstance();
            logger.log("Message from Thread 1 - Hash: " + logger.hashCode());
        });

        Thread thread2 = new Thread(() -> {
            Logger logger = Logger.getInstance();
            logger.log("Message from Thread 2 - Hash: " + logger.hashCode());
        });

        Thread thread3 = new Thread(() -> {
            AdvancedLogger logger = AdvancedLogger.getInstance();
            logger.log("Message from Thread 3 (Advanced) - Hash: " + logger.hashCode());
        });

        Thread thread4 = new Thread(() -> {
            AdvancedLogger logger = AdvancedLogger.getInstance();
            logger.log("Message from Thread 4 (Advanced) - Hash: " + logger.hashCode());
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            System.err.println("Thread interrupted: " + e.getMessage());
        }

        System.out.println("\nAll threads completed. Check hash codes above to verify singleton behavior.");
    }
}