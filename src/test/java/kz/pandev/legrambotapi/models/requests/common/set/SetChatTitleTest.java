package kz.pandev.legrambotapi.models.requests.common.set;

import kz.pandev.legrambotapi.Config;
import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.responses.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class SetChatTitleTest {

    @Test
    void setChatTitle() throws InterruptedException {
        Response response = Config.bot.execute(new SetChatTitle(Config.testGroupId, "Test Bot Group " + System.currentTimeMillis()));
        assertTrue(response.isOk());
        Config.bot.execute(new SetChatTitle(Config.testGroupId, "LegramBotApiTest"));

        assertThrows(WrongParameterTypeException.class, () ->
                Config.bot.execute(new SetChatTitle(Config.testImage, "LegramBotApiTest")));

        Thread.sleep(1000);
    }

}