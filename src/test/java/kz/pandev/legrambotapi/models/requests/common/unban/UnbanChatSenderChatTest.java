package kz.pandev.legrambotapi.models.requests.common.unban;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.responses.Response;
import org.junit.jupiter.api.Test;

import static kz.pandev.legrambotapi.Config.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class UnbanChatSenderChatTest {

    @Test
    void unbanChatSenderChat() throws InterruptedException {
        Response response = bot.execute(new UnbanChatSenderChat(testChannelName, testAdminInGroupId));
        assertTrue(response.isOk());

        assertThrows(WrongParameterTypeException.class, () ->
                bot.execute(new UnbanChatSenderChat(testImage, testAdminInGroupId)));

        Thread.sleep(1000);
    }

}