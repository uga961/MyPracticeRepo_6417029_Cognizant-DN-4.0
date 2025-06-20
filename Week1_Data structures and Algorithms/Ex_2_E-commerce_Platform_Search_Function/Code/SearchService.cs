using System;

namespace SearchDemo;

public static class SearchService
{
    public static Product? LinearSearchById(Product[] products, int targetId)
    {
        foreach (var p in products)
        {
            if (p.ProductId == targetId)
                return p;
        }
        return null;
    }

    public static Product? BinarySearchById(Product[] sortedProducts, int targetId)
    {
        int lo = 0, hi = sortedProducts.Length - 1;
        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            int midId = sortedProducts[mid].ProductId;

            if (midId == targetId)
                return sortedProducts[mid];
            if (midId < targetId)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return null;
    }
}
