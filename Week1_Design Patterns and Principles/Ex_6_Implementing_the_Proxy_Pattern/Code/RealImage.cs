using System;
using System.Threading;

namespace ProxyPatternExample;

public class RealImage : IImage
{
    private readonly string _fileName;

    public RealImage(string fileName)
    {
        _fileName = fileName;
        LoadFromRemoteServer(fileName);
    }

    private void LoadFromRemoteServer(string fileName)
    {
        Console.WriteLine($"Loading image from remote server: {fileName}");
        Thread.Sleep(1_000); 
    }

    public void Display() => Console.WriteLine($"Displaying image: {_fileName}");
}
