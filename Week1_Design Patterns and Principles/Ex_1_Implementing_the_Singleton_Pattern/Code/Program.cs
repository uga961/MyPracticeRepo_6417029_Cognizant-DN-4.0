using SingletonDemo;

Console.WriteLine("SINGLETON PATTERN DEMONSTRATION");
Console.WriteLine(new string('=', 60));

DemonstrateBasicSingleton();
Console.WriteLine("\n" + new string('=', 60) + "\n");

DemonstrateAdvancedSingleton();
Console.WriteLine("\n" + new string('=', 60) + "\n");

DemonstrateThreadSafety();
Console.WriteLine("\n" + new string('=', 60) + "\n");

SingletonTest.Run();


static void DemonstrateBasicSingleton()
{
    Console.WriteLine("DEMO 1: Basic Singleton Pattern (Double‑Checked Locking)");
    Console.WriteLine(new string('-', 50));

    var logger1 = Logger.Instance;
    var logger2 = Logger.Instance;
    var logger3 = Logger.Instance;

    Console.WriteLine($"Instance 1 Hash: {logger1.GetHashCode()}");
    Console.WriteLine($"Instance 2 Hash: {logger2.GetHashCode()}");
    Console.WriteLine($"Instance 3 Hash: {logger3.GetHashCode()}");
    Console.WriteLine($"Are all instances equal? {logger1 == logger2 && logger2 == logger3}");

    logger1.Log("Testing basic singleton pattern");
    logger2.LogInfo("This message comes from the same instance");
    logger3.LogWarning("All loggers are actually the same object");
}

static void DemonstrateAdvancedSingleton()
{
    Console.WriteLine("DEMO 2: Advanced Singleton Pattern (Static Holder)");
    Console.WriteLine(new string('-', 50));

    var adv1 = AdvancedLogger.Instance;
    var adv2 = AdvancedLogger.Instance;
    var adv3 = AdvancedLogger.Instance;

    Console.WriteLine($"Advanced Instance 1 Hash: {adv1.GetHashCode()}");
    Console.WriteLine($"Advanced Instance 2 Hash: {adv2.GetHashCode()}");
    Console.WriteLine($"Advanced Instance 3 Hash: {adv3.GetHashCode()}");
    Console.WriteLine($"Are all advanced instances equal? {adv1 == adv2 && adv2 == adv3}");

    adv1.Log("Testing advanced singleton pattern");
    adv2.LogInfo("This is more efficient and thread‑safe");
    adv3.LogWarning("No synchronization overhead!");
}

static void DemonstrateThreadSafety()
{
    Console.WriteLine("DEMO 3: Thread Safety Test");
    Console.WriteLine(new string('-', 50));

    var t1 = new Thread(() =>
    {
        var logger = Logger.Instance;
        logger.Log($"Message from Thread 1 - Hash: {logger.GetHashCode()}");
    });

    var t2 = new Thread(() =>
    {
        var logger = Logger.Instance;
        logger.Log($"Message from Thread 2 - Hash: {logger.GetHashCode()}");
    });

    var t3 = new Thread(() =>
    {
        var logger = AdvancedLogger.Instance;
        logger.Log($"Message from Thread 3 (Advanced) - Hash: {logger.GetHashCode()}");
    });

    var t4 = new Thread(() =>
    {
        var logger = AdvancedLogger.Instance;
        logger.Log($"Message from Thread 4 (Advanced) - Hash: {logger.GetHashCode()}");
    });

    t1.Start(); t2.Start(); t3.Start(); t4.Start();
    t1.Join();  t2.Join();  t3.Join();  t4.Join();

    Console.WriteLine("All threads completed. Check hash codes above to verify singleton behavior.");
}
