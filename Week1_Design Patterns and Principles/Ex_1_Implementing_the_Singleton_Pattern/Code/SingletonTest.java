

public class SingletonTest {

    public static void main(String[] args) {
        System.out.println("=== Testing Singleton Pattern Implementation ===\n");

        testSingletonBehavior();

        System.out.println("\n" + "=".repeat(50) + "\n");

        testLoggerFunctionality();

        System.out.println("\n" + "=".repeat(50) + "\n");

        testFromDifferentMethods();
    }

    private static void testSingletonBehavior() {
        System.out.println("Test 1: Verifying Singleton Behavior");
        System.out.println("-".repeat(40));

        Logger logger1 = Logger.getInstance();
        System.out.println("First instance: " + logger1.getInstanceDetails());

        Logger logger2 = Logger.getInstance();
        System.out.println("Second instance: " + logger2.getInstanceDetails());

        Logger logger3 = Logger.getInstance();
        System.out.println("Third instance: " + logger3.getInstanceDetails());

        if (logger1 == logger2 && logger2 == logger3) {
            System.out.println("✓ SUCCESS: All instances are the same object");
            System.out.println("✓ Singleton pattern is working correctly");
        } else {
            System.out.println("✗ FAILURE: Instances are different objects");
        }

        System.out.println("\nHash Code Verification:");
        System.out.println("logger1 hash: " + logger1.hashCode());
        System.out.println("logger2 hash: " + logger2.hashCode());
        System.out.println("logger3 hash: " + logger3.hashCode());
    }

    private static void testLoggerFunctionality() {
        System.out.println("Test 2: Testing Logger Functionality");
        System.out.println("-".repeat(40));

        Logger logger = Logger.getInstance();

        logger.log("Application started successfully");
        logger.logInfo("User login attempt");
        logger.logWarning("Memory usage is high");
        logger.logError("Database connection failed");
        logger.log("Application shutting down");
    }

    private static void testFromDifferentMethods() {
        System.out.println("Test 3: Testing from Different Methods");
        System.out.println("-".repeat(40));

        Logger loggerFromMethod1 = getLoggerFromMethod1();
        Logger loggerFromMethod2 = getLoggerFromMethod2();

        System.out.println("Logger from method 1: " + loggerFromMethod1.getInstanceDetails());
        System.out.println("Logger from method 2: " + loggerFromMethod2.getInstanceDetails());

        if (loggerFromMethod1 == loggerFromMethod2) {
            System.out.println("✓ SUCCESS: Same instance returned from different methods");
        } else {
            System.out.println("✗ FAILURE: Different instances returned from different methods");
        }

        loggerFromMethod1.log("Message from method 1 context");
        loggerFromMethod2.log("Message from method 2 context");
    }

    private static Logger getLoggerFromMethod1() {
        System.out.println("Getting logger instance from method 1...");
        return Logger.getInstance();
    }

    private static Logger getLoggerFromMethod2() {
        System.out.println("Getting logger instance from method 2...");
        return Logger.getInstance();
    }
}