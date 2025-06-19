package com.example.factory.documents;
import java.time.LocalDateTime;
public interface Document {
    void open();
    void save();
    void close();
    void print();
    String getDocumentType();
    LocalDateTime getCreationTime();
}