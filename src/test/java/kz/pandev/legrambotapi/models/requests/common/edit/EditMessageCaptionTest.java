package kz.pandev.legrambotapi.models.requests.common.edit;

import kz.pandev.legrambotapi.Config;
import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.common.send.SendDocument;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.responses.SendResponse;
import kz.pandev.legrambotapi.models.types.common.inline.keyboard.InlineKeyboardMarkup;
import kz.pandev.legrambotapi.models.types.common.inline.keyboard.buttons.CallbackDataButton;
import kz.pandev.legrambotapi.models.types.common.message.Message;
import kz.pandev.legrambotapi.models.types.common.message.MessageEntity;
import kz.pandev.legrambotapi.utils.enums.ParseMode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class EditMessageCaptionTest {

    @Test
    void editMessageCaption() throws InterruptedException {
        SendResponse resp = Config.bot.execute(new SendDocument(Config.personalChatId, Config.testDoc)
                .disableContentTypeDetection(true)
                .disableNotification(true)
                .caption("caption"));
        int messageId = resp.getMessage().getMessageId();

        String text = "Update " + System.currentTimeMillis() + " <b>bold</b>";
        SendResponse sendResponse = (SendResponse) Config.bot.execute(
                new EditMessageCaption(Config.personalChatId, messageId)
                        .caption(text)
                        .parseMode(ParseMode.HTML)
                        .replyMarkup(new InlineKeyboardMarkup(new CallbackDataButton("text", "data"))));
        assertTrue(sendResponse.isOk());

        Message message = sendResponse.getMessage();
        assertEquals(text.replace("<b>", "").replace("</b>", ""), message.getCaption());

        MessageEntity captionEntity = message.getCaptionEntities().get(0);
        assertEquals(MessageEntity.Type.BOLD, captionEntity.getType());
        assertEquals((Integer) 21, captionEntity.getOffset());
        assertEquals((Integer) 4, captionEntity.getLength());

        Response response = Config.bot.execute(new EditMessageCaption("AgAAAPrwAQCj_Q4D2s-51_8jsuU")
                .caption(text)
                .entities(List.of(new MessageEntity(MessageEntity.Type.ITALIC, 0, 2))));
        if (!response.isOk()) {
            assertEquals(400, response.getErrorCode());
            assertEquals("Bad Request: MESSAGE_ID_INVALID", response.getDescription());
        }

        assertThrows(WrongParameterTypeException.class, () ->
                Config.bot.execute(new EditMessageCaption(Config.testImage, messageId)));

        Thread.sleep(1000);
    }

}