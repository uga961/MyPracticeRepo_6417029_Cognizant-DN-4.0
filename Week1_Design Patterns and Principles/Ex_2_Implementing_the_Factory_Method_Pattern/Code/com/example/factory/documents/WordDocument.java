package com.example.factory.documents;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class WordDocument implements Document {
    private LocalDateTime creationTime;
    private String fileName;
    public WordDocument() {
        this.creationTime = LocalDateTime.now();
        this.fileName = "Document_" + creationTime.format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")) + ".docx";
    }
    @Override
    public void open() {
        System.out.println("Opening Word document: " + fileName);
        System.out.println("Loading Microsoft Word application...");
    }
    @Override
    public void save() {
        System.out.println("Saving Word document: " + fileName);
        System.out.println("Document saved in .docx format");
    }
    @Override
    public void close() {
        System.out.println("Closing Word document: " + fileName);
        System.out.println("Microsoft Word application closed");
    }
    @Override
    public void print() {
        System.out.println("Printing Word document: " + fileName);
        System.out.println("Sending to default printer...");
    }
    @Override
    public String getDocumentType() {
        return "Microsoft Word Document";
    }
    @Override
    public LocalDateTime getCreationTime() {
        return creationTime;
    }
}
