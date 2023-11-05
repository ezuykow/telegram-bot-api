package kz.pandev.legrambotapi.models.requests.common.get;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.common.get.GetChatResponse;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to get up-to-date information about the chat (current name of the user
 * for one-on-one conversations, current username of a user, group or channel, etc.). Returns a Chat object on success.
 * @author ezuykow
 */
public class GetChat extends Request<GetChat, GetChatResponse> {

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     */
    public GetChat(@NotNull Object chatId) {
        super(GetChatResponse.class);
        if (chatId instanceof Number || chatId instanceof String) {
            addParameter("chat_id", chatId);
        } else {
            throw new WrongParameterTypeException("Type of parameter chatId must be Number or String (if it's chat username)");
        }
    }
}