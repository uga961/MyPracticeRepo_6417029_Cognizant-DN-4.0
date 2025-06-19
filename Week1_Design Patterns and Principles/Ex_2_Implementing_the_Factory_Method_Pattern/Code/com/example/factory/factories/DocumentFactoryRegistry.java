package com.example.factory.factories;
import java.util.HashMap;
import java.util.Map;
public class DocumentFactoryRegistry {
    private static final Map<String, DocumentFactory> factories = new HashMap<>();
    static {
        factories.put("WORD", new WordDocumentFactory());
        factories.put("PDF", new PdfDocumentFactory());
        factories.put("EXCEL", new ExcelDocumentFactory());
    }
    public static DocumentFactory getFactory(String documentType) {
        DocumentFactory factory = factories.get(documentType.toUpperCase());
        if (factory == null) {
            throw new IllegalArgumentException("Unknown document type: " + documentType);
        }
        return factory;
    }
    public static String[] getSupportedTypes() {
        return factories.keySet().toArray(new String[0]);
    }
}