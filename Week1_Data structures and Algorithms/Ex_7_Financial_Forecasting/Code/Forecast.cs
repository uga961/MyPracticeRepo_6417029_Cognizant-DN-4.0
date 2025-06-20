namespace FinancialForecast;

public static class Forecast
{
    // Recursive method to calculate future value
    public static double FutureValueRecursive(double initialAmount, double growthRate, int years)
    {
        if (years == 0)
            return initialAmount;

        return FutureValueRecursive(initialAmount, growthRate, years - 1) * (1 + growthRate);
    }

    // Optimized method using exponentiation (non-recursive)
    public static double FutureValueOptimized(double initialAmount, double growthRate, int years)
    {
        return initialAmount * Math.Pow(1 + growthRate, years);
    }
}
