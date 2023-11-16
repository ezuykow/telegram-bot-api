package kz.pandev.legrambotapi.additional.test.classes;

import kz.pandev.legrambotapi.models.types.common.Document;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author ezuykow
 */
public class DocumentTest {

    public static void check(Document document) {
        check(document, true);
    }

    public static void check(Document document, boolean checkSize) {
        assertNotNull(document.getFileId());
        assertNotNull(document.getFileUniqueId());
        assertNotNull(document.getFileName());
        assertNotNull(document.getMimeType());
        if (checkSize) assertNotNull(document.getFileSize());
    }
}