package kz.pandev.legrambotapi.models.requests.common;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.responses.Response;
import org.junit.jupiter.api.Test;

import static kz.pandev.legrambotapi.Config.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class LeaveChatTest {

    @Test
    void leaveChat() throws InterruptedException {
        Response response = bot.execute(new LeaveChat(personalChatId));
        assertFalse(response.isOk());
        assertEquals(400, response.getErrorCode());
        assertEquals("Bad Request: chat member status can't be changed in private chats", response.getDescription());

        assertThrows(WrongParameterTypeException.class, () ->
                bot.execute(new LeaveChat(testImage)));

        Thread.sleep(1000);
    }

}