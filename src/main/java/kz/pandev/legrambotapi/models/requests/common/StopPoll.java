package kz.pandev.legrambotapi.models.requests.common;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.common.PollResponse;
import kz.pandev.legrambotapi.models.types.common.inline.keyboard.InlineKeyboardMarkup;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Use this method to stop a poll which was sent by the bot. On success, the stopped Poll is returned.
 * @author ezuykow
 */
@Getter
public class StopPoll extends Request<StopPoll, PollResponse> {

    /**
     * Optional. A new message inline keyboard.
     */
    @Nullable
    private InlineKeyboardMarkup replyMarkup;

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
     * Set parameter {@link StopPoll#replyMarkup}
     * @param replyMarkup new parameter value
     * @return this request
     */
    public StopPoll replyMarkup(InlineKeyboardMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
        return addParameter("reply_markup", replyMarkup);
    }

    //endregion
}