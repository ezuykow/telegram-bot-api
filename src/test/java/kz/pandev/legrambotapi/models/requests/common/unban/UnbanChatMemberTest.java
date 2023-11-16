package kz.pandev.legrambotapi.models.requests.common.unban;

import kz.pandev.legrambotapi.Config;
import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.responses.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class UnbanChatMemberTest {

    @Test
    void unbanChatMember() throws InterruptedException {
        Response response = Config.bot.execute(new UnbanChatMember(Config.testGroupId, Config.myUserID));
        assertFalse(response.isOk());
        assertEquals(400, response.getErrorCode());
        assertEquals("Bad Request: can't remove chat owner", response.getDescription());

        // returns true for non-banned member with onlyIfBanned(true)
        response = Config.bot.execute(new UnbanChatMember(Config.testGroupId, Config.myUserID).onlyIfBanned(true));
        assertTrue(response.isOk());

        assertThrows(WrongParameterTypeException.class, () ->
                Config.bot.execute(new UnbanChatMember(Config.testImage, Config.myUserID)));

        Thread.sleep(1000);
    }

}