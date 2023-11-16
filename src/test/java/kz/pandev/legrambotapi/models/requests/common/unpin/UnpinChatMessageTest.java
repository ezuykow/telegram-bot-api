package kz.pandev.legrambotapi.models.requests.common.unpin;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.common.PinChatMessage;
import kz.pandev.legrambotapi.models.requests.common.send.SendMessage;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.responses.SendResponse;
import org.junit.jupiter.api.Test;

import static kz.pandev.legrambotapi.Config.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class UnpinChatMessageTest {

    @Test
    void unpinChatMessage() throws InterruptedException {
        SendResponse sr = bot.execute(new SendMessage(testGroupId, "to unpin").disableNotification(true));
        bot.execute(new PinChatMessage(testGroupId, sr.getMessage().getMessageId()).disableNotification(true));
        Response response = bot.execute(new UnpinChatMessage(testGroupId).messageId(sr.getMessage().getMessageId()));
        assertTrue(response.isOk());

        assertThrows(WrongParameterTypeException.class, () ->
                bot.execute(new UnpinChatMessage(testImage)));

        Thread.sleep(1000);
    }

}