using System;

namespace FactoryDemo.Documents;

public interface IDocument
{
    void Open();
    void Save();
    void Close();
    void Print();

    string GetDocumentType();
    DateTime GetCreationTime();
}
