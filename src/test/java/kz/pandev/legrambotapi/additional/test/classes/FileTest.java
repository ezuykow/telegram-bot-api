package kz.pandev.legrambotapi.additional.test.classes;

import kz.pandev.legrambotapi.models.types.common.File;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author ezuykow
 */
public class FileTest {

    public static void check(File file) {
        check(file, true);
    }

    public static void check(File file, boolean path) {
        assertNotNull(file.getFileId());
        assertNotNull(file.getFileUniqueId());
        assertNotNull(file.getFileSize());
        if (path) assertNotNull(file.getFilePath());
    }
}