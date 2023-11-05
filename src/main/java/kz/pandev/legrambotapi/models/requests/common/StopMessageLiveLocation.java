package kz.pandev.legrambotapi.models.requests.common;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.responses.SendResponse;
import kz.pandev.legrambotapi.models.types.common.inline.keyboard.InlineKeyboardMarkup;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Use this method to stop updating a live location message before live_period expires.
 * On success, if the message is not an inline message, the edited Message is returned, otherwise True is returned.
 * @author ezuykow
 */
@Getter
public class StopMessageLiveLocation extends Request<StopMessageLiveLocation, Response> {

    /**
     * Optional. An inline keyboard.
     */
    @Nullable
    private InlineKeyboardMarkup replyMarkup;

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param messageId Identifier of the message with live location to stop
     */
    public StopMessageLiveLocation(@NotNull Object chatId, int messageId) {
        super(SendResponse.class);
        if (chatId instanceof Number || chatId instanceof String) {
            addParameter("chat_id", chatId);
            addParameter("message_id", messageId);
        } else {
            throw new WrongParameterTypeException("Type of parameter chatId must be Number or String (if it's chat username)");
        }
    }

    /**
     * @param inlineMessageId Identifier of the inline message
     */
    public StopMessageLiveLocation(String inlineMessageId) {
        super(Response.class);
        addParameter("inline_message_id", inlineMessageId);
    }

    //region API

    /**
     * Set parameter {@link StopMessageLiveLocation#replyMarkup}
     * @param replyMarkup new parameter value
     * @return this request
     */
    public StopMessageLiveLocation replyMarkup(InlineKeyboardMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
        return addParameter("reply_markup", replyMarkup);
    }

    //endregion
}