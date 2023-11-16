package kz.pandev.legrambotapi.models.requests.common;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.responses.Response;
import org.junit.jupiter.api.Test;

import static kz.pandev.legrambotapi.Config.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class PromoteChatMemberTest {

    @Test
    void promoteChatMember() throws InterruptedException {
        Response response = bot.execute(
                new PromoteChatMember(testGroupId, testBotId)
                        .isAnonymous(false)
                        .canChangeInfo(false)
                        .canPostMessages(false)
                        .canEditMessages(false)
                        .canDeleteMessages(false)
                        .canInviteUsers(false)
                        .canRestrictMembers(false)
                        .canPinMessages(false)
                        .canManageChat(false)
                        .canManageVideoChats(false)
                        .canManageTopics(false)
                        .canPostStories(false)
                        .canEditStories(false)
                        .canDeleteStories(false)
                        .canPromoteMembers(true));
        assertFalse(response.isOk());
        assertEquals(400, response.getErrorCode());
        assertEquals("Bad Request: can't promote self", response.getDescription());

        assertThrows(WrongParameterTypeException.class, () ->
                new PromoteChatMember(testImage, testBotId));

        Thread.sleep(1000);
    }

}