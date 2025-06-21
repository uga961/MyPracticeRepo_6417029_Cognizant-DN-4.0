using System;

namespace ProxyPatternExample;

public class ProxyImage : IImage
{
    private RealImage? _realImage;
    private readonly string _fileName;

    public ProxyImage(string fileName) => _fileName = fileName;

    public void Display()
    {
        if (_realImage == null)
        {
            Console.WriteLine("Proxy: Initializing real image…");
            _realImage = new RealImage(_fileName);       // lazy init
        }
        else
        {
            Console.WriteLine("Proxy: Using cached image…");
        }

        _realImage.Display();
    }
}
