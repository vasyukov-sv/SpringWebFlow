package ru.javabegin.training.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Map;

/**
 * This class is a work around for working with iText 5.x in Spring. The code here is almost identical to the AbstractPdfView class.
 */
abstract class AbstractPdfView extends AbstractView {

    AbstractPdfView() {
        setContentType("application/pdf");
    }

    @Override
    protected boolean generatesDownloadContent() {
        return true;
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // IE workaround: write into byte array first.
        ByteArrayOutputStream baos = createTemporaryOutputStream();

        // Apply preferences and build metadata.
        Document document = newDocument();
        PdfWriter writer = newWriter(document, baos);
        prepareWriter(writer);
//        buildPdfMetadata(model, document, request);

        // Build PDF document.
        document.open();
        buildPdfDocument(document);
        document.close();

        // Flush to HTTP response.
        writeToResponse(response, baos);
    }

    private Document newDocument() {
        return new Document(PageSize.A4);
    }

    private PdfWriter newWriter(Document document, OutputStream os) throws DocumentException {
        return PdfWriter.getInstance(document, os);
    }

    private void prepareWriter(PdfWriter writer) {
        writer.setViewerPreferences(getViewerPreferences());
    }

    private int getViewerPreferences() {
        return PdfWriter.ALLOW_PRINTING | PdfWriter.PageLayoutSinglePage;
    }

    protected abstract void buildPdfDocument(Document document) throws Exception;
}
