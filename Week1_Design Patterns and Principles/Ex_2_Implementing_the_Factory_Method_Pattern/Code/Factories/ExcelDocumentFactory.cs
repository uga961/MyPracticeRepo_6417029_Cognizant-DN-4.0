using System;
using FactoryDemo.Documents;

namespace FactoryDemo.Factories;

public sealed class ExcelDocumentFactory : DocumentFactory
{
    public override IDocument CreateDocument()
    {
        Console.WriteLine("ExcelDocumentFactory: Creating new Excel document…");
        return new ExcelDocument();
    }
}
