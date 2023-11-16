package kz.pandev.legrambotapi.models.requests.common;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.responses.Response;
import org.junit.jupiter.api.Test;

import static kz.pandev.legrambotapi.Config.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class ChatJoinRequestTest {

    @Test
    void chatJoinRequest() throws InterruptedException {
        Response response = bot.execute(new ApproveChatJoinRequest(testGroupId, testBotId));
        assertFalse(response.isOk());
        assertEquals("Bad Request: USER_ALREADY_PARTICIPANT", response.getDescription());

        response = bot.execute(new DeclineChatJoinRequest(testGroupId, testBotId));
        assertFalse(response.isOk());
        assertEquals("Bad Request: HIDE_REQUESTER_MISSING", response.getDescription());

        assertThrows(WrongParameterTypeException.class, () ->
                bot.execute(new ApproveChatJoinRequest(testImage, testBotId)));
        assertThrows(WrongParameterTypeException.class, () ->
                bot.execute(new DeclineChatJoinRequest(testImage, testBotId)));

        Thread.sleep(1000);
    }

}