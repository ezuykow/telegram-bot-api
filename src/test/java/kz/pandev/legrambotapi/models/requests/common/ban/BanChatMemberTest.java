package kz.pandev.legrambotapi.models.requests.common.ban;

import kz.pandev.legrambotapi.Config;
import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.responses.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class BanChatMemberTest {

    @Test
    void banChatMember() throws InterruptedException {
        Response response = Config.bot.execute(new BanChatMember(Config.testGroupId, Config.myUserID)
                .untilDate(123).revokeMessages(true));
        assertFalse(response.isOk());
        assertEquals(400, response.getErrorCode());
        assertEquals("Bad Request: can't remove chat owner", response.getDescription());

        assertThrows(WrongParameterTypeException.class, () ->
                Config.bot.execute(new BanChatMember(Config.testImage, Config.myUserID)));

        Thread.sleep(1000);
    }

}