package kz.pandev.legrambotapi.additional.test.classes;

import kz.pandev.legrambotapi.models.types.stickers.Sticker;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author ezuykow
 */
public class StickerTest {

    public static void check(Sticker sticker, boolean emoji, boolean fileSize) {
        assertNotNull(sticker.getFileId());
        assertNotNull(sticker.getFileUniqueId());
        assertNotNull(sticker.getWidth());
        assertNotNull(sticker.getHeight());
        PhotoSizeTest.checkPhotos(List.of(sticker.getThumbnail()));
        PhotoSizeTest.checkPhotos(List.of(sticker.getThumbnail()));
        if (emoji) assertNotNull(sticker.getEmoji());
        if (fileSize) assertNotNull(sticker.getFileSize());
    }
}