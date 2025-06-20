using System;
using FactoryDemo.Documents;

namespace FactoryDemo.Factories;

public abstract class DocumentFactory
{
    public abstract IDocument CreateDocument();


    public IDocument ProcessDocument()
    {
        Console.WriteLine("=== Document Processing Started ===");
        var doc = CreateDocument();
        Console.WriteLine($"Document Type: {doc.GetDocumentType()}");
        Console.WriteLine($"Creation Time: {doc.GetCreationTime()}");
        doc.Open();
        doc.Save();
        Console.WriteLine("=== Document Processing Completed ===");
        return doc;
    }
}
