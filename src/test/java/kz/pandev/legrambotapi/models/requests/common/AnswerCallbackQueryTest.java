package kz.pandev.legrambotapi.models.requests.common;

import kz.pandev.legrambotapi.additional.test.classes.MessageTest;
import kz.pandev.legrambotapi.additional.test.classes.UserTest;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.types.Update;
import kz.pandev.legrambotapi.models.types.common.CallbackQuery;
import org.junit.jupiter.api.Test;

import static kz.pandev.legrambotapi.Config.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class AnswerCallbackQueryTest {

    @Test
    void answerCallback() throws InterruptedException {
        // callbackQuery sent by client after pressing on InlineKeyboardButton (used in sendGame() test)
        CallbackQuery callbackQuery = gson.fromJson(testCallbackQuery, Update.class).getCallbackQuery();

        assertNotNull(callbackQuery);
        assertFalse(callbackQuery.getId().isEmpty());
        UserTest.checkUser(callbackQuery.getFrom(), true);
        assertEquals(1111111L , callbackQuery.getFrom().getId());
        MessageTest.checkMessage(callbackQuery.getMessage());
        assertFalse(callbackQuery.getChatInstance().isEmpty());
        assertEquals("game", callbackQuery.getGameShortName());
        assertEquals("1234csdbsk4839", callbackQuery.getInlineMessageId());
        assertEquals("Data from button callback", callbackQuery.getData());

        Response response = bot.execute(new AnswerCallbackQuery(callbackQuery.getId())
                .text("answer callback")
                .url("telegram.me/pengrad_test_bot?game=pengrad_test_game")
                .showAlert(false)
                .cacheTime(1));

        assertFalse(response.isOk());
        assertEquals(400, response.getErrorCode());
        assertEquals("Bad Request: query is too old and response timeout expired or query ID is invalid", response.getDescription());
        Thread.sleep(1000);
    }

}