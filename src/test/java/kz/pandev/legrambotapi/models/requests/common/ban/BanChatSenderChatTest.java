package kz.pandev.legrambotapi.models.requests.common.ban;

import kz.pandev.legrambotapi.Config;
import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.responses.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author ezuykow
 */
class BanChatSenderChatTest {

    @Test
    void banChatSenderChat() throws InterruptedException {
        Response response = Config.bot.execute(new BanChatSenderChat(Config.testChannelName, Config.testAdminInGroupId));
        assertTrue(response.isOk());

        assertThrows(WrongParameterTypeException.class, () ->
                Config.bot.execute(new BanChatSenderChat(Config.testImage, Config.testAdminInGroupId)));
        Thread.sleep(1000);
    }

}