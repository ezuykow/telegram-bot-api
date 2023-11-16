package kz.pandev.legrambotapi.addons.update;

import kz.pandev.legrambotapi.models.types.common.chat.Chat;
import kz.pandev.legrambotapi.models.types.common.message.Message;
import kz.pandev.legrambotapi.models.types.common.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ezuykow
 */
class ExtendedUpdateTest {

    @Test
    void allTests() {
        ExtendedUpdate up1 = new ExtendedUpdate();
        ExtendedUpdate up2 = new ExtendedUpdate();
        Message m = new Message();
        User u = new User();
        Chat c = new Chat();
        long userId = 1233L;
        long chatId = 45656L;
        int threadId = 1;

        u.setId(userId);
        c.setId(chatId);
        m.setFrom(u);
        m.setChat(c);
        m.setMessageThreadId(threadId);

        up1.setMessage(m);
        up2.setMessage(m);

        assertEquals(UpdateContentType.MESSAGE, up1.getContentType());
        assertEquals(userId, up1.getSenderUserId());
        assertEquals(chatId, up1.getSenderChatId());
        assertEquals(threadId, up1.getSenderChatThreadId());
        assertEquals(up1.toString(), up2.toString());
        assertEquals(up1, up2);
        assertEquals(up1.hashCode(), up2.hashCode());
    }

}