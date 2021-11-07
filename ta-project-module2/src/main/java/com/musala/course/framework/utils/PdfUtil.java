package com.musala.course.framework.utils;

import java.io.File;
import java.util.Optional;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import lombok.SneakyThrows;

public class PdfUtil {

    private PdfUtil() {
        throw new AssertionError();
    }

    @SneakyThrows
    public static Optional<String> toString(String filePath) {
        String text = null;

        try (PDDocument document = PDDocument.load(new File(filePath));) {
            if (!document.isEncrypted()) {
                PDFTextStripper stripper = new PDFTextStripper();
                text = stripper.getText(document);
            }
        }

        return Optional.ofNullable(text);
    }

}
