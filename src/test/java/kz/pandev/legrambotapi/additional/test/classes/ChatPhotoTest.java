package kz.pandev.legrambotapi.additional.test.classes;

import kz.pandev.legrambotapi.models.types.common.chat.ChatPhoto;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author ezuykow
 */
public class ChatPhotoTest {

    public static void check(ChatPhoto photo) {
        assertNotNull(photo.getSmallFileId());
        assertNotNull(photo.getSmallFileUniqueId());
        assertNotNull(photo.getBigFileId());
        assertNotNull(photo.getBigFileUniqueId());
    }
}