package com.example.factory.factories;
import com.example.factory.documents.Document;
import com.example.factory.documents.ExcelDocument;
public class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        System.out.println("ExcelDocumentFactory: Creating new Excel document...");
        return new ExcelDocument();
    }
}
