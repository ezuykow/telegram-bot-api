package kz.pandev.legrambotapi.models.requests.games;

import kz.pandev.legrambotapi.additional.test.classes.GameHighScoreTest;
import kz.pandev.legrambotapi.additional.test.classes.GameTest;
import kz.pandev.legrambotapi.additional.test.classes.MessageTest;
import kz.pandev.legrambotapi.models.requests.common.edit.EditMessageText;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.responses.SendResponse;
import kz.pandev.legrambotapi.models.types.common.inline.keyboard.InlineKeyboardButton;
import kz.pandev.legrambotapi.models.types.common.inline.keyboard.InlineKeyboardMarkup;
import kz.pandev.legrambotapi.models.types.common.inline.keyboard.buttons.*;
import kz.pandev.legrambotapi.models.types.common.message.Message;
import kz.pandev.legrambotapi.models.types.games.Game;
import kz.pandev.legrambotapi.models.types.games.GameHighScore;
import kz.pandev.legrambotapi.utils.enums.ParseMode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static kz.pandev.legrambotapi.Config.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class GamesTest {

    @Test
    void sendGame() throws InterruptedException {
        InlineKeyboardButton[] buttons = {
                new CallbackGameButton("inline game"),
                new CallbackDataButton("inline ok","callback ok"),
                new CallbackDataButton("cancel", "callback cancel"),
                new UrlButton("url", "https://google.com/"),
                new SwitchInlineQueryButton("switch inline", "query"),
                new SwitchInlineQueryCurrentChatButton("switch inline current", "query"),
        };

        InlineKeyboardButton[][] inlineKeyboard = new InlineKeyboardButton[1][];
        inlineKeyboard[0] = buttons;
        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup(inlineKeyboard);

        String desc = "ezuykow_test_game";
        Message message = bot.execute(new SendGame(personalChatId, desc).replyMarkup(keyboardMarkup)).getMessage();
        message = ((SendResponse) bot.execute(new EditMessageText(personalChatId, message.getMessageId(), "test _game_")
                .parseMode(ParseMode.MARKDOWN_V2)
                .replyMarkup(keyboardMarkup))
        ).getMessage();
        MessageTest.checkMessage(message);
        Game game = message.getGame();
        GameTest.check(game);
        assertEquals(desc, game.getDescription());

        List<InlineKeyboardButton> actualButtons = message.getReplyMarkup().getInlineKeyboard().get(0);
        assertEquals(buttons.length, actualButtons.size());
        assertNotNull(actualButtons.get(0).getCallbackGame());
        for (int i = 1; i < buttons.length; i++) {
            assertEquals(buttons[i].getText(), actualButtons.get(i).getText());
            if (buttons[i].getPay() != null) {
                assertFalse(buttons[i].getPay());
            }
        }
        assertEquals(buttons[1].getCallbackData(), actualButtons.get(1).getCallbackData());
        assertEquals(buttons[2].getCallbackData(), actualButtons.get(2).getCallbackData());
        assertEquals(buttons[3].getUrl(), actualButtons.get(3).getUrl());
        assertEquals(buttons[4].getSwitchInlineQuery(), actualButtons.get(4).getSwitchInlineQuery());
        assertEquals(buttons[5].getSwitchInlineQueryCurrentChat(), actualButtons.get(5).getSwitchInlineQueryCurrentChat());
        Thread.sleep(1000);
    }

    @Test
    void setGameScore() throws InterruptedException {
        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup(new CallbackGameButton("inline game"));
        String desc = "ezuykow_test_game";
        Message message = bot.execute(new SendGame(personalChatId, desc).replyMarkup(keyboardMarkup)).getMessage();

        int res = (int) (System.currentTimeMillis() / 1000);

        SendResponse sendResponse = (SendResponse) bot.execute(
                new SetGameScore(myUserID, res + 1, personalChatId, message.getMessageId()).force(true).disableEditMessage(true));
        GameTest.check(sendResponse.getMessage().getGame());

        Response response = bot.execute(new SetGameScore(personalChatId, res, "AgAAAPrwAQCj_Q4D2s-51_8jsuU"));
        assertFalse(response.isOk());
        assertEquals(400, response.getErrorCode());
        assertEquals("Bad Request: MESSAGE_ID_INVALID", response.getDescription());
        Thread.sleep(1000);
    }

    @Test
    void getGameHighScores() throws InterruptedException {
        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup(new CallbackGameButton("inline game"));
        String desc = "ezuykow_test_game";
        Message message = bot.execute(new SendGame(personalChatId, desc).replyMarkup(keyboardMarkup)).getMessage();

        List<GameHighScore> scores = bot.execute(new GetGameHighScores(myUserID, personalChatId, message.getMessageId())
        ).getGameHighScores();
        GameHighScoreTest.check(scores);

        Response response = bot.execute(new GetGameHighScores(personalChatId, "AgAAAPrwAQCj_Q4D2s-51_8jsuU"));
        assertFalse(response.isOk());
        assertEquals(400, response.getErrorCode());
        assertEquals("Bad Request: MESSAGE_ID_INVALID", response.getDescription());
        Thread.sleep(1000);
    }


}