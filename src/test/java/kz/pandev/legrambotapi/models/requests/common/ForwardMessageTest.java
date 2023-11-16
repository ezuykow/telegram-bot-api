package kz.pandev.legrambotapi.models.requests.common;

import kz.pandev.legrambotapi.additional.test.classes.MessageTest;
import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.common.send.SendMessage;
import kz.pandev.legrambotapi.models.responses.SendResponse;
import kz.pandev.legrambotapi.models.types.common.chat.Chat;
import kz.pandev.legrambotapi.models.types.common.message.Message;
import kz.pandev.legrambotapi.models.types.common.message.MessageEntity;
import org.junit.jupiter.api.Test;

import static kz.pandev.legrambotapi.Config.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class ForwardMessageTest {

    @Test
    void forwardMessage() throws InterruptedException {
        SendResponse forForwarding = bot.execute(new SendMessage(testGroupId, "for forwarding @ezuykow").disableNotification(true));
        int forwardMessageId = forForwarding.getMessage().getMessageId();

        SendResponse response = bot.execute(new ForwardMessage(personalChatId, testGroupId, forwardMessageId).disableNotification(true));
        int forwardMessageIdUser = response.getMessage().getMessageId();
        Message message = response.getMessage();
        MessageTest.checkMessage(message);
        assertNotNull(message.getForwardDate());
        assertNull(message.getForwardSenderName());
        assertNotNull(message.getForwardFrom());

        // message from user with open account
        message = bot.execute(new ForwardMessage(testGroupId, personalChatId, forwardMessageIdUser).disableNotification(true)).getMessage();
        MessageTest.checkMessage(message);
        assertNotNull(message.getForwardDate());
        assertNull(message.getForwardSenderName());
        assertNotNull(message.getForwardFrom());

        forForwarding = bot.execute(new SendMessage(testChannelName, "for forwarding").disableNotification(true));
        int forwardMessageIdInChannel = forForwarding.getMessage().getMessageId();

        message = bot.execute(new ForwardMessage(testGroupId, testChannelName, forwardMessageIdInChannel).disableNotification(true)).getMessage();
        assertNull(message.getAuthorSignature());
        assertNull(message.getForwardSignature());
        Chat chat = message.getForwardFromChat();
        assertEquals(testChannelName, "@" + chat.getUsername());
        assertEquals(Chat.Type.CHANNEL, chat.getType());
        assertNull(message.getForwardSenderName());

        message = bot.execute(new ForwardMessage(personalChatId, testGroupId, forwardMessageId).messageThreadId(0)
                .disableNotification(true)).getMessage();
        assertEquals(MessageEntity.Type.MENTION, message.getEntities().get(0).getType());

        assertThrows(WrongParameterTypeException.class, () ->
                bot.execute(new ForwardMessage(testImage, testGroupId, forwardMessageId)));

        Thread.sleep(1000);
    }

}