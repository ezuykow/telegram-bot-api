package kz.pandev.legrambotapi.additional.test.classes;

import kz.pandev.legrambotapi.models.types.common.PhotoSize;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author ezuykow
 */
public class PhotoSizeTest {

    public static void checkPhotos(List<PhotoSize> photos) {
        checkPhotos(true, photos);
    }

    public static void checkPhotos(boolean checkSize, List<PhotoSize> photos) {
        for (PhotoSize photo : photos) {
            assertNotNull(photo.getFileId());
            assertNotNull(photo.getFileUniqueId());
            assertNotNull(photo.getWidth());
            assertNotNull(photo.getHeight());
            if (checkSize) assertNotNull(photo.getFileSize());
        }
    }
}