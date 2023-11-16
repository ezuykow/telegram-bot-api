package kz.pandev.legrambotapi.models.requests.common;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.common.send.SendLocation;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.responses.SendResponse;
import kz.pandev.legrambotapi.models.types.common.inline.keyboard.InlineKeyboardMarkup;
import kz.pandev.legrambotapi.models.types.common.inline.keyboard.buttons.CallbackDataButton;
import org.junit.jupiter.api.Test;

import static kz.pandev.legrambotapi.Config.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class StopMessageLiveLocationTest {

    @Test
    void stopMessageLiveLocation() throws InterruptedException {
        SendResponse liveLocation = bot.execute(new SendLocation(personalChatId, 20, 100)
                .livePeriod(60)
                .heading(10)
                .proximityAlertRadius(1000));

        Response response = bot.execute(new StopMessageLiveLocation(personalChatId, liveLocation.getMessage().getMessageId()));
        assertTrue(response.isOk());

        response = bot.execute(new StopMessageLiveLocation("AgAAAPrwAQCj_Q4D2s-51_8jsuU")
                .replyMarkup(new InlineKeyboardMarkup(new CallbackDataButton("text", "data"))));
        assertFalse(response.isOk());
        assertEquals(400, response.getErrorCode());
        assertEquals("Bad Request: MESSAGE_ID_INVALID", response.getDescription());

        assertThrows(WrongParameterTypeException.class, () ->
                bot.execute(new StopMessageLiveLocation(testImage, liveLocation.getMessage().getMessageId())));

        Thread.sleep(1000);
    }

}