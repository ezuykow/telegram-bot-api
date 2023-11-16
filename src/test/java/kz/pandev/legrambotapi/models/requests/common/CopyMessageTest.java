package kz.pandev.legrambotapi.models.requests.common;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.common.send.SendMessage;
import kz.pandev.legrambotapi.models.responses.MessageIdResponse;
import kz.pandev.legrambotapi.models.responses.SendResponse;
import kz.pandev.legrambotapi.models.types.common.message.MessageEntity;
import kz.pandev.legrambotapi.models.types.common.reply.keyboard.ReplyKeyboardRemove;
import kz.pandev.legrambotapi.utils.enums.ParseMode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static kz.pandev.legrambotapi.Config.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class CopyMessageTest {

    @Test
    void copyMessage() throws InterruptedException {
        SendResponse forForwarding = bot.execute(new SendMessage(testGroupId, "for copy").disableNotification(true));
        int forwardMessageId = forForwarding.getMessage().getMessageId();

        MessageIdResponse response = bot.execute(new CopyMessage(personalChatId, testGroupId, forwardMessageId)
                .messageThreadId(0)
                .caption("new **caption**")
                .parseMode(ParseMode.MARKDOWN_V2)
                .captionEntities(List.of(new MessageEntity(MessageEntity.Type.BOLD, 0, 1)))
                .allowSendingWithoutReply(false)
                .replyToMessageId(1)
                .disableNotification(true)
                .replyMarkup(new ReplyKeyboardRemove())
        );
        assertTrue(response.getMessageId() > 0);

        assertThrows(WrongParameterTypeException.class, () ->
                bot.execute(new CopyMessage(testImage, testGroupId, forwardMessageId)));

        Thread.sleep(1000);
    }

}