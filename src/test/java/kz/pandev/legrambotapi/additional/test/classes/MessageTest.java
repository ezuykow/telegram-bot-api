package kz.pandev.legrambotapi.additional.test.classes;

import kz.pandev.legrambotapi.additional.test.classes.ChatTest;
import kz.pandev.legrambotapi.models.types.common.message.Message;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
public class MessageTest {

    public static void checkMessage(Message message) {
        assertNotNull(message.getMessageId());
        assertNotNull(message.getDate());
        ChatTest.checkChat(message.getChat());
    }

    public static void checkTextMessage(Message message) {
        checkMessage(message);
        assertNotNull(message.getText());
        assertNull(message.getNewChatMembers());
        assertNull(message.getLeftChatMember());
        assertNull(message.getNewChatTitle());
        assertNull(message.getNewChatPhoto());
        assertNull(message.getDeleteChatPhoto());
        assertNull(message.getGroupChatCreated());
        assertNull(message.getSupergroupChatCreated());
        assertNull(message.getChannelChatCreated());
        assertNull(message.getMigrateToChatId());
        assertNull(message.getMigrateFromChatId());
        assertNull(message.getPinnedMessage());
        assertNull(message.getSuccessfulPayment());
        assertNull(message.getConnectedWebsite());
        assertNull(message.getMessageThreadId());
        assertFalse(message.isTopicMessage());
        assertNull(message.getIsAutomaticForward());
        assertNull(message.getHasMediaSpoiler());
        assertNull(message.getMessageAutoDeleteTimerChanged());
        assertNull(message.getUserShared());
        assertNull(message.getChatShared());
        assertNull(message.getProximityAlertTriggered());
        assertNull(message.getForumTopicCreated());
        assertNull(message.getForumTopicEdited());
        assertNull(message.getForumTopicClosed());
        assertNull(message.getForumTopicReopened());
        assertNull(message.getGeneralForumTopicHidden());
        assertNull(message.getGeneralForumTopicUnhidden());
        assertNull(message.getWriteAccessAllowed());
        assertNull(message.getVideoChatStarted());
        assertNull(message.getVideoChatEnded());
        assertNull(message.getVideoChatParticipantsInvited());
        assertNull(message.getVideoChatScheduled());
        assertNull(message.getWebAppData());
    }
}