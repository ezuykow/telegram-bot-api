package kz.pandev.legrambotapi.models.requests.common.send;

import kz.pandev.legrambotapi.Config;
import kz.pandev.legrambotapi.additional.test.classes.MessageTest;
import kz.pandev.legrambotapi.models.responses.SendResponse;
import kz.pandev.legrambotapi.models.types.common.ForceReply;
import kz.pandev.legrambotapi.models.types.common.chat.ChatAdministratorRights;
import kz.pandev.legrambotapi.models.types.common.keyboard.button.KeyboardButton;
import kz.pandev.legrambotapi.models.types.common.keyboard.button.KeyboardButtonRequestChat;
import kz.pandev.legrambotapi.models.types.common.keyboard.button.KeyboardButtonRequestUser;
import kz.pandev.legrambotapi.models.types.common.message.Message;
import kz.pandev.legrambotapi.models.types.common.reply.keyboard.ReplyKeyboardMarkup;
import kz.pandev.legrambotapi.models.types.common.reply.keyboard.ReplyKeyboardRemove;
import kz.pandev.legrambotapi.utils.enums.ParseMode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class SendMessageTest {

    @Test
    void sendMessage() throws InterruptedException {
        SendResponse sendResponse = Config.bot.execute(new SendMessage(Config.personalChatId, "reply this message").replyMarkup(
                new ForceReply().inputFieldPlaceholder("input-placeholder").selective(true)
        ).disableNotification(true));
        int messageId = sendResponse.getMessage().getMessageId();
        MessageTest.checkTextMessage(sendResponse.getMessage());
        assertNotNull(sendResponse.getMessage().getFrom());

        sendResponse = Config.bot.execute(new SendMessage(Config.personalChatId, "remove keyboard")
                .replyMarkup(new ReplyKeyboardRemove())
                .disableNotification(true)
                .replyToMessageId(messageId)
        );
        System.out.println(sendResponse);
        MessageTest.checkTextMessage(sendResponse.getMessage());
        assertNotNull(sendResponse.getMessage().getReplyToMessage());

        sendResponse = Config.bot.execute(new SendMessage(Config.personalChatId, "message with keyboard")
                .parseMode(ParseMode.HTML)
                .disableWebPagePreview(false)
                .protectContent(true)
                .replyMarkup(new ReplyKeyboardMarkup(
                        new KeyboardButton("contact").requestContact(true),
                        new KeyboardButton("location").requestLocation(true),
                        new KeyboardButton("user").requestUser(
                                new KeyboardButtonRequestUser(123).userIsBot(false).userIsPremium(false)),
                        new KeyboardButton("chat").requestChat(
                                new KeyboardButtonRequestChat(321, false)
                                        .chatIsForum(false).chatHasUsername(false).chatIsCreated(true)
                                        .userAdministratorRights(new ChatAdministratorRights().canChangeInfo(true))
                                        .botAdministratorRights(new ChatAdministratorRights().canChangeInfo(true))
                                        .botIsMember(true)))
                        .oneTimeKeyboard(true)
                        .resizeKeyboard(true)
                        .inputFieldPlaceholder("input-placeholder")
                        .isPersistent(false)
                        .selective(true)));
        assertTrue(sendResponse.getMessage().getHasProtectedContent());
        MessageTest.checkTextMessage(sendResponse.getMessage());

        sendResponse = Config.bot.execute(new SendMessage(Config.personalChatId, "simple buttons")
                .replyMarkup(new ReplyKeyboardMarkup(new KeyboardButton("ok"), new KeyboardButton("cancel"))));
        MessageTest.checkTextMessage(sendResponse.getMessage());
        Thread.sleep(1000);
    }

    @Test
    void sendMessageToChannel() throws InterruptedException {
        String url = "https://google.com/";
        SendMessage request = new SendMessage(Config.testChannelName, "channel message [GG](" + url + ")")
                .parseMode(ParseMode.MARKDOWN).disableNotification(true);
        SendResponse sendResponse = Config.bot.execute(request);
        Message message = sendResponse.getMessage();
        MessageTest.checkTextMessage(message);
        assertEquals(url, message.getEntities().get(0).getUrl());
        assertEquals(Config.testChannelId, message.getSenderChat().getId());
        Thread.sleep(1000);
    }

    @Test
    void sendMessageToChannelId() throws InterruptedException {
        SendMessage request = new SendMessage(Config.testChannelId, "channel by id message")
                .disableNotification(true);
        SendResponse sendResponse = Config.bot.execute(request);
        Message message = sendResponse.getMessage();
        MessageTest.checkTextMessage(message);
        Thread.sleep(1000);
    }

}