package kz.pandev.legrambotapi.models.requests.common.edit;

import kz.pandev.legrambotapi.Config;
import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.common.send.SendLocation;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.responses.SendResponse;
import kz.pandev.legrambotapi.models.types.common.inline.keyboard.InlineKeyboardMarkup;
import kz.pandev.legrambotapi.models.types.common.inline.keyboard.buttons.CallbackDataButton;
import kz.pandev.legrambotapi.models.types.common.inline.keyboard.buttons.CallbackGameButton;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class EditMessageLiveLocationTest {

    @Test
    void editMessageLiveLocation() throws InterruptedException {
        SendResponse liveLocation = Config.bot.execute(new SendLocation(Config.personalChatId, 20, 100)
                .livePeriod(60)
                .heading(10)
                .proximityAlertRadius(1000));
        Response response = Config.bot.execute(new EditMessageLiveLocation(Config.personalChatId,
                liveLocation.getMessage().getMessageId(),
                21, 105)
                .replyMarkup(new InlineKeyboardMarkup(new CallbackDataButton("button", "data"))));
        assertTrue(response.isOk());

        String buttonText = "btn_" + System.currentTimeMillis();
        response = Config.bot.execute(
                new EditMessageLiveLocation("AgAAAPrwAQCj_Q4D2s-51_8jsuU", 21, 102)
                        .horizontalAccuracy(1f)
                        .heading(10)
                        .proximityAlertRadius(100)
                        .replyMarkup(new InlineKeyboardMarkup(new CallbackGameButton(buttonText)))
        );
        if (!response.isOk()) {
            assertEquals(400, response.getErrorCode());
            assertEquals("Bad Request: MESSAGE_ID_INVALID", response.getDescription());
        } else {
            assertTrue(response.isOk());
        }

        assertThrows(WrongParameterTypeException.class, () ->
                Config.bot.execute(new SendLocation(Config.testImage, 20, 100)));

        Thread.sleep(1000);
    }

}