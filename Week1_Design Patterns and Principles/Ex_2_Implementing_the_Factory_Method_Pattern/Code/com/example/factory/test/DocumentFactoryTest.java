package com.example.factory.test;
import com.example.factory.documents.Document;
import com.example.factory.factories.*;
public class DocumentFactoryTest {
    public static void main(String[] args) {
        System.out.println("=== Factory Method Pattern Demo ===\n");   
        testBasicFactoryUsage();
        System.out.println("\n" + "=".repeat(50) + "\n");
        testFactoryRegistry();
        System.out.println("\n" + "=".repeat(50) + "\n");
        testDocumentOperations();
    }
    private static void testBasicFactoryUsage() {
        System.out.println("1. Basic Factory Usage:");  
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.processDocument();
        wordDoc.close();       
        System.out.println();      
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.processDocument();
        pdfDoc.close();
        System.out.println();
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.processDocument();
        excelDoc.close();
    }
    private static void testFactoryRegistry() {
        System.out.println("2. Factory Registry Usage:");
        System.out.println("Supported document types: " + String.join(", ", DocumentFactoryRegistry.getSupportedTypes()));   
        String[] documentTypes = {"WORD", "PDF", "EXCEL"};
        for (String type : documentTypes) {
            try {
                DocumentFactory factory = DocumentFactoryRegistry.getFactory(type);
                Document doc = factory.createDocument();
                doc.open();
                doc.save();
                doc.close();
                System.out.println();
            } catch (IllegalArgumentException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
    private static void testDocumentOperations() {
        System.out.println("3. Full Document Operations:");   
        DocumentFactory[] factories = {
            new WordDocumentFactory(),
            new PdfDocumentFactory(),
            new ExcelDocumentFactory()
        };
        for (DocumentFactory factory : factories) {
            Document doc = factory.createDocument();
            System.out.println("Document Type: " + doc.getDocumentType());
            doc.open();
            doc.save();
            doc.print();
            doc.close();
            System.out.println("-".repeat(30));
        }
    }
}