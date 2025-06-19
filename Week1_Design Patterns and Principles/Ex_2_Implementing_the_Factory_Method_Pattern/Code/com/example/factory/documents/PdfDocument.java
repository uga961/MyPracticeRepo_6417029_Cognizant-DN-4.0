package com.example.factory.documents;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class PdfDocument implements Document {
    private LocalDateTime creationTime;
    private String fileName;
    public PdfDocument() {
        this.creationTime = LocalDateTime.now();
        this.fileName = "Document_" + creationTime.format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")) + ".pdf";
    }
    @Override
    public void open() {
        System.out.println("Opening PDF document: " + fileName);
        System.out.println("Loading PDF reader application...");
    }
    @Override
    public void save() {
        System.out.println("Saving PDF document: " + fileName);
        System.out.println("Document saved in .pdf format");
    }
    @Override
    public void close() {
        System.out.println("Closing PDF document: " + fileName);
        System.out.println("PDF reader application closed");
    }
    @Override
    public void print() {
        System.out.println("Printing PDF document: " + fileName);
        System.out.println("High-quality print mode enabled...");
    }
    @Override
    public String getDocumentType() {
        return "Portable Document Format";
    }
    @Override
    public LocalDateTime getCreationTime() {
        return creationTime;
    }
}

