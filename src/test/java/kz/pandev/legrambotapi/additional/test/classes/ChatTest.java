package kz.pandev.legrambotapi.additional.test.classes;

import kz.pandev.legrambotapi.additional.test.classes.ChatPhotoTest;
import kz.pandev.legrambotapi.models.types.common.chat.Chat;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author ezuykow
 */
public class ChatTest {

    public static void checkChat(Chat chat) {
        checkChat(chat, chat.getPhoto() != null);
    }

    public static void checkChat(Chat chat, boolean photo) {
        assertNotNull(chat.getId());
        assertNotNull(chat.getType());
        if (photo) ChatPhotoTest.check(chat.getPhoto());
    }
}