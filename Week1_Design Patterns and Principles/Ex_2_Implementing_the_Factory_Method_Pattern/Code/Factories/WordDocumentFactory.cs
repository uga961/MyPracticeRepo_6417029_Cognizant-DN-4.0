using System;
using FactoryDemo.Documents;

namespace FactoryDemo.Factories;

public sealed class WordDocumentFactory : DocumentFactory
{
    public override IDocument CreateDocument()
    {
        Console.WriteLine("WordDocumentFactory: Creating new Word document…");
        return new WordDocument();
    }
}
