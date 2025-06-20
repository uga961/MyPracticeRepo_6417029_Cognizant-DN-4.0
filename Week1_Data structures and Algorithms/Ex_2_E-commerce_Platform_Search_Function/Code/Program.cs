using System;
using System.Diagnostics;
using SearchDemo;

var products = GenerateProducts(100_000);
var sorted = products.OrderBy(p => p.ProductId).ToArray();
int sampleId = 73912;

var sw = Stopwatch.StartNew();
var linearResult = SearchService.LinearSearchById(products, sampleId);
sw.Stop();
Console.WriteLine(linearResult is null
    ? "Linear search: not found"
    : $"Linear search found: {linearResult.ProductName} in {sw.ElapsedMilliseconds} ms");

sw.Restart();
var binaryResult = SearchService.BinarySearchById(sorted, sampleId);
sw.Stop();
Console.WriteLine(binaryResult is null
    ? "Binary search: not found"
    : $"Binary search found: {binaryResult.ProductName} in {sw.ElapsedMilliseconds} ms");

static Product[] GenerateProducts(int n)
{
    var rnd = new Random(42);
    var list = new Product[n];
    for (int i = 0; i < n; i++)
    {
        int id = i + 1;
        string name = $"Product {id}";
        string cat = rnd.Next(3) switch { 0 => "Books", 1 => "Electronics", _ => "Clothing" };
        list[i] = new Product(id, name, cat);
    }
    return list;
}
