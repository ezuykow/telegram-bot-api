package kz.pandev.legrambotapi.models.requests.common.unpin;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.responses.Response;
import org.junit.jupiter.api.Test;

import static kz.pandev.legrambotapi.Config.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class UnpinAllChatMessagesTest {

    @Test
    void unpinAllChatMessages() throws InterruptedException {
        Response response = bot.execute(new UnpinAllChatMessages(testGroupId));
        assertTrue(response.isOk());

        assertThrows(WrongParameterTypeException.class, () ->
                bot.execute(new UnpinAllChatMessages(testImage)));

        Thread.sleep(1000);
    }

}