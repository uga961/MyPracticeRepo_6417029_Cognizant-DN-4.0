using System;
using FinancialForecast;

class Program
{
    static void Main()
    {
        double initial = 10000;      // ₹10,000
        double rate = 0.08;          // 8% growth
        int years = 10;

        Console.WriteLine("=== Financial Forecasting Tool ===\n");
        Console.WriteLine($"Initial Amount: ₹{initial}");
        Console.WriteLine($"Growth Rate: {rate * 100}%");
        Console.WriteLine($"Years: {years}\n");

        double future1 = Forecast.FutureValueRecursive(initial, rate, years);
        Console.WriteLine($"[Recursive] Forecast after {years} years: ₹{future1:F2}");

        double future2 = Forecast.FutureValueOptimized(initial, rate, years);
        Console.WriteLine($"[Optimized] Forecast after {years} years: ₹{future2:F2}");
    }
}
