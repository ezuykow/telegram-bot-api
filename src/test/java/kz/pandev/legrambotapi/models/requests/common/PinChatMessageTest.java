package kz.pandev.legrambotapi.models.requests.common;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.common.send.SendMessage;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.responses.SendResponse;
import org.junit.jupiter.api.Test;

import static kz.pandev.legrambotapi.Config.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class PinChatMessageTest {

    @Test
    void pinChatMessage() throws InterruptedException {
        SendResponse sr = bot.execute(new SendMessage(testGroupId, "to pin").disableNotification(true));
        Response response = bot.execute(new PinChatMessage(testGroupId, sr.getMessage().getMessageId()).disableNotification(true));
        if (!response.isOk()) {
            assertEquals(400, response.getErrorCode());
            assertEquals("Bad Request: CHAT_NOT_MODIFIED", response.getDescription());
        } else {
            assertTrue(response.isOk());
        }

        assertThrows(WrongParameterTypeException.class, () ->
                bot.execute(new PinChatMessage(testImage, sr.getMessage().getMessageId())));

        Thread.sleep(1000);
    }

}