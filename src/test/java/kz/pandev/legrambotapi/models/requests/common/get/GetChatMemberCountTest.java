package kz.pandev.legrambotapi.models.requests.common.get;

import kz.pandev.legrambotapi.Config;
import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.responses.common.get.GetChatMemberCountResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class GetChatMemberCountTest {

    @Test
    void getChatMemberCount() throws InterruptedException {
        GetChatMemberCountResponse response = Config.bot.execute(new GetChatMemberCount(Config.personalChatId));
        assertEquals(2, response.getCount());

        assertThrows(WrongParameterTypeException.class, () ->
                Config.bot.execute(new GetChatMemberCount(Config.testImage)));

        Thread.sleep(1000);
    }

}