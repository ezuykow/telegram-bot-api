package kz.pandev.legrambotapi.models.requests.common;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.types.common.chat.ChatPermissions;
import org.junit.jupiter.api.Test;

import static kz.pandev.legrambotapi.Config.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class RestrictChatMemberTest {

    @Test
    void restrictChatMember() throws InterruptedException {
        ChatPermissions permissions = new ChatPermissions()
                .canChangeInfo(true)
                .canInviteUsers(true)
                .canPinMessages(true)
                .canSendAudios(true)
                .canSendDocuments(true)
                .canSendPhotos(true)
                .canSendVideos(true)
                .canSendVideoNotes(true)
                .canSendVoiceNotes(true)
                .canSendPolls(true); // implies can_send_messages

        Response response = bot.execute(
                new RestrictChatMember(testGroupId, testBotId, permissions)
                        .untilDate((int) (System.currentTimeMillis() / 1000) + 5)
                        .useIndependentChatPermissions(false)
        );
        System.out.println(response);
        assertFalse(response.isOk());
        assertEquals(400, response.getErrorCode());
        assertEquals("Bad Request: can't restrict self", response.getDescription());

        assertThrows(WrongParameterTypeException.class, () ->
                bot.execute(new RestrictChatMember(testImage, testBotId, permissions)));

        Thread.sleep(1000);
    }

}