package com.example.factory.factories;
import com.example.factory.documents.Document;
import com.example.factory.documents.PdfDocument;
public class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        System.out.println("PdfDocumentFactory: Creating new PDF document...");
        return new PdfDocument();
    }
}