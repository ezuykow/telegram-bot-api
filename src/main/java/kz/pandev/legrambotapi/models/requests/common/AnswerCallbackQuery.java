package kz.pandev.legrambotapi.models.requests.common;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to send answers to callback queries sent from inline keyboards.
 * The answer will be displayed to the user as a notification at the top of the chat screen or as an alert.
 * On success, True is returned.
 * @apiNote Alternatively, the user can be redirected to the specified Game URL.
 * For this option to work, you must first create a game for your bot via @BotFather
 * and accept the terms. Otherwise, you may use links like t.me/your_bot?start=XXXX
 * that open your bot with a parameter.
 * @author ezuykow
 */
public class AnswerCallbackQuery extends Request<AnswerCallbackQuery, Response> {

    /**
     * @param callbackQueryId Unique identifier for the query to be answered
     */
    public AnswerCallbackQuery(@NotNull String callbackQueryId) {
        super(Response.class);
        addParameter("callback_query_id", callbackQueryId);
    }

    //region API

    /**
     * Set parameter text
     * @param text Text of the notification. If not specified, nothing will be shown to the user, 0-200 characters
     * @return this request
     */
    public AnswerCallbackQuery text(@NotNull String text) {
        return addParameter("text", text);
    }

    /**
     * Set parameter show_alert
     * @param showAlert If True, an alert will be shown by the client instead of a notification at the top
     *                 of the chat screen. Defaults to false.
     * @return this request
     */
    public AnswerCallbackQuery showAlert(boolean showAlert) {
        return addParameter("show_alert", showAlert);
    }

    /**
     * Set parameter url
     * @param url URL that will be opened by the user's client. If you have created a Game and accepted the conditions
     *           via @BotFather, specify the URL that opens your game - note that this will only work if the query
     *           comes from a callback_game button. Otherwise, you may use links like t.me/your_bot?start=XXXX
     *           that open your bot with a parameter.
     * @return this request
     */
    public AnswerCallbackQuery url(@NotNull String url) {
        return addParameter("url", url);
    }

    /**
     * Set parameter cache_time
     * @param cacheTime The maximum amount of time in seconds that the result of the callback query may be cached
     *                 client-side. Telegram apps will support caching starting in version 3.14. Defaults to 0.
     * @return this request
     */
    public AnswerCallbackQuery cacheTime(int cacheTime) {
        return addParameter("cache_time", cacheTime);
    }

    //endregion
}