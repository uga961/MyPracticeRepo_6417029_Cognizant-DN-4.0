using System;
using ProxyPatternExample;

Console.WriteLine("=== Proxy Pattern Demo ===\n");

IImage img1 = new ProxyImage("nature.jpg");

Console.WriteLine("First display:");
img1.Display();        // loads & displays

Console.WriteLine("\nSecond display:");
img1.Display();        // cached

Console.WriteLine("\nThird display, new proxy:");
IImage img2 = new ProxyImage("mountain.jpg");
img2.Display();
