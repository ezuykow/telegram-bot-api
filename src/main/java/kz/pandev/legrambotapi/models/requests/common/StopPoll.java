package kz.pandev.legrambotapi.models.requests.common;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.common.PollResponse;
import kz.pandev.legrambotapi.models.types.common.inline.keyboard.InlineKeyboardMarkup;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to stop a poll which was sent by the bot. On success, the stopped Poll is returned.
 * @author ezuykow
 */
public class StopPoll extends Request<StopPoll, PollResponse> {

    public StopPoll(@NotNull Object chatId, int messageId) {
        super(PollResponse.class);
        if (chatId instanceof Number || chatId instanceof String) {
            addParameter("chat_id", chatId);
            addParameter("message_id", messageId);
        } else {
            throw new WrongParameterTypeException("Type of parameter chatId must be Number or String (if it's chat username)");
        }
    }

    //region API

    /**
     * Set parameter reply_markup
     * @param replyMarkup A new message inline keyboard.
     * @return this request
     */
    public StopPoll replyMarkup(@NotNull InlineKeyboardMarkup replyMarkup) {
        return addParameter("reply_markup", replyMarkup);
    }

    //endregion
}