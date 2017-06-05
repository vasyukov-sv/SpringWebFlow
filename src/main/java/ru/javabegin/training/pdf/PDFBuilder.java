package ru.javabegin.training.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;

public class PDFBuilder extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Document doc) throws Exception {
        doc.add(new Paragraph("test paragraph"));
    }
}