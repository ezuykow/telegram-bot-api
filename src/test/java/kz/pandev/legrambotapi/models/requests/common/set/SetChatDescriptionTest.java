package kz.pandev.legrambotapi.models.requests.common.set;

import kz.pandev.legrambotapi.Config;
import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.responses.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class SetChatDescriptionTest {

    @Test
    void setChatDescription() throws InterruptedException {
        Response response = Config.bot.execute(new SetChatDescription(Config.testGroupId,
                "New desc " + System.currentTimeMillis()));
        assertTrue(response.isOk());
        Config. bot.execute(new SetChatDescription(Config.testGroupId, "desc"));

        assertThrows(WrongParameterTypeException.class, () -> Config.bot.execute(
                new SetChatDescription(Config.testImage, "desc")));

        Thread.sleep(1000);
    }

}