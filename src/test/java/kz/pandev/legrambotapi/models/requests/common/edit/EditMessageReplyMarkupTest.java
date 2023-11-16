package kz.pandev.legrambotapi.models.requests.common.edit;

import kz.pandev.legrambotapi.Config;
import kz.pandev.legrambotapi.addons.SimpleMessageSender;
import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.responses.SendResponse;
import kz.pandev.legrambotapi.models.types.common.inline.keyboard.InlineKeyboardMarkup;
import kz.pandev.legrambotapi.models.types.common.inline.keyboard.buttons.CallbackDataButton;
import kz.pandev.legrambotapi.models.types.common.inline.keyboard.buttons.CallbackGameButton;
import kz.pandev.legrambotapi.models.types.common.inline.keyboard.buttons.UrlButton;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class EditMessageReplyMarkupTest {

    @Test
    void editMessageReplyMarkup() throws InterruptedException {
        SendResponse messageToEdit = SimpleMessageSender.sendTextWithKeyboard(Config.bot, Config.personalChatId, "messageToEdit",
                new InlineKeyboardMarkup(new CallbackDataButton("button", "data")));
        int messageId = messageToEdit.getMessage().getMessageId();

        String text = "Update" + System.currentTimeMillis();
        InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup(new UrlButton(text, "https://google.com"));
        InlineKeyboardMarkup gameKeyboard = new InlineKeyboardMarkup(new CallbackGameButton(text));

        Response response = Config.bot.execute(new EditMessageReplyMarkup(Config.personalChatId, messageId)
                .replyMarkup(keyboard));
        assertTrue(response.isOk());

        response = Config.bot.execute(new EditMessageReplyMarkup("AgAAAPrwAQCj_Q4D2s-51_8jsuU")
                .replyMarkup(gameKeyboard));
        if (!response.isOk()) {
            assertEquals(400, response.getErrorCode());
            assertEquals("Bad Request: MESSAGE_ID_INVALID", response.getDescription());
        }

        assertThrows(WrongParameterTypeException.class, () ->
                Config.bot.execute(new EditMessageReplyMarkup(Config.testImage, messageId)
                        .replyMarkup(keyboard)));

        Thread.sleep(1000);
    }

}