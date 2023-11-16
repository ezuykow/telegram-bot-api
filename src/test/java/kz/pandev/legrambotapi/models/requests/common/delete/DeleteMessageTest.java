package kz.pandev.legrambotapi.models.requests.common.delete;

import kz.pandev.legrambotapi.Config;
import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.common.send.SendMessage;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.types.common.message.Message;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class DeleteMessageTest {

    @Test
    void deleteMessage() throws InterruptedException {
        Message message = Config.bot.execute(new SendMessage(Config.personalChatId, "message for delete"))
                .getMessage();
        Response response = Config.bot.execute(new DeleteMessage(Config.personalChatId, message.getMessageId()));
        assertTrue(response.isOk());

        assertThrows(WrongParameterTypeException.class, () ->
                Config.bot.execute(new DeleteMessage(Config.testImage, message.getMessageId())));

        Thread.sleep(1000);
    }

}