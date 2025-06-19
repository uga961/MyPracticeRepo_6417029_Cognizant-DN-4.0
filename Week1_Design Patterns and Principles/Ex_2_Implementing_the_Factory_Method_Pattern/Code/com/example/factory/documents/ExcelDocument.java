package com.example.factory.documents;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class ExcelDocument implements Document {
    private LocalDateTime creationTime;
    private String fileName; 
    public ExcelDocument() {
        this.creationTime = LocalDateTime.now();
        this.fileName = "Spreadsheet_" + creationTime.format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")) + ".xlsx";
    }
    @Override
    public void open() {
        System.out.println("Opening Excel document: " + fileName);
        System.out.println("Loading Microsoft Excel application...");
    }
    @Override
    public void save() {
        System.out.println("Saving Excel document: " + fileName);
        System.out.println("Workbook saved in .xlsx format");
    }
    @Override
    public void close() {
        System.out.println("Closing Excel document: " + fileName);
        System.out.println("Microsoft Excel application closed");
    }
    @Override
    public void print() {
        System.out.println("Printing Excel document: " + fileName);
        System.out.println("Printing all worksheets...");
    }
    @Override
    public String getDocumentType() {
        return "Microsoft Excel Spreadsheet";
    }
    @Override
    public LocalDateTime getCreationTime() {
        return creationTime;
    }
}
