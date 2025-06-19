package com.example.factory.factories;
import com.example.factory.documents.Document;
public abstract class DocumentFactory{
    public abstract Document createDocument();
    public Document processDocument()
    {
        System.out.println("=== Document Processing Started ===");
        Document document = createDocument();
        System.out.println("Document Type: " + document.getDocumentType());
        System.out.println("Creation Time: " + document.getCreationTime());
        document.open();
        document.save();
        System.out.println("=== Document Processing Completed ===");
        return document;
    }    
}