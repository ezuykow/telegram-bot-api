package kz.pandev.legrambotapi.models.requests.common.edit;

import kz.pandev.legrambotapi.Config;
import kz.pandev.legrambotapi.addons.SimpleMessageSender;
import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.responses.SendResponse;
import kz.pandev.legrambotapi.models.types.common.inline.keyboard.InlineKeyboardMarkup;
import kz.pandev.legrambotapi.models.types.common.inline.keyboard.buttons.CallbackDataButton;
import kz.pandev.legrambotapi.utils.enums.ParseMode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class EditMessageTextTest {

    @Test
    void editMessageText() throws InterruptedException {
        SendResponse messageToEdit = SimpleMessageSender.sendText(Config.bot, Config.personalChatId, "messageToEdit");
        int messageId = messageToEdit.getMessage().getMessageId();

        String text = "Update " + System.currentTimeMillis();
        Response response = Config.bot.execute(new EditMessageText(Config.personalChatId, messageId, text)
                .parseMode(ParseMode.MARKDOWN)
                .disableWebPagePreview(true)
                .replyMarkup(new InlineKeyboardMarkup(new CallbackDataButton(text, "data"))));
        assertTrue(response.isOk());
        assertNotNull(((SendResponse) response).getMessage().getEditDate());

        response = Config.bot.execute(new EditMessageText("AgAAAN3wAQCj_Q4DjX4ok5VEUZU", text));
        if (!response.isOk()) {
            assertEquals(400, response.getErrorCode());
            assertEquals("Bad Request: MESSAGE_ID_INVALID", response.getDescription());
        }

        assertThrows(WrongParameterTypeException.class, () ->
                Config.bot.execute(new EditMessageText(Config.testImage, messageId, text)));

        Thread.sleep(1000);
    }

}