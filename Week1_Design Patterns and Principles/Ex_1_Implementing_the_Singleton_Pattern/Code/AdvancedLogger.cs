using System;

namespace SingletonDemo;


public sealed class AdvancedLogger : ICloneable
{
    private AdvancedLogger()
    {
        Console.WriteLine($"AdvancedLogger instance created at: {GetCurrentTimestamp()}");
    }


    private static class SingletonHolder
    {
        internal static readonly AdvancedLogger Instance = new();
    }

    public static AdvancedLogger Instance => SingletonHolder.Instance;

    public void Log(string message)        => Console.WriteLine($"[{GetCurrentTimestamp()}] ADVANCED LOG: {message}");
    public void LogError(string message)   => Console.Error.WriteLine($"[{GetCurrentTimestamp()}] ADVANCED ERROR: {message}");
    public void LogWarning(string message) => Console.WriteLine($"[{GetCurrentTimestamp()}] ADVANCED WARNING: {message}");
    public void LogInfo(string message)    => Console.WriteLine($"[{GetCurrentTimestamp()}] ADVANCED INFO: {message}");

    public string InstanceDetails => $"AdvancedLogger instance: {GetHashCode()}";
    private static string GetCurrentTimestamp() => DateTime.Now.ToString("yyyy-MM-dd HH:mm:ss");

   
    public object Clone() => throw new NotSupportedException("Cannot clone singleton instance");
}
