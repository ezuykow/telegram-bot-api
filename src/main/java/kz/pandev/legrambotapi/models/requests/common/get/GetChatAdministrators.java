package kz.pandev.legrambotapi.models.requests.common.get;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.common.get.GetChatAdministratorsResponse;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to get a list of administrators in a chat, which aren't bots. Returns an Array of ChatMember objects.
 * @author ezuykow
 */
public class GetChatAdministrators extends Request<GetChatAdministrators, GetChatAdministratorsResponse> {

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     */
    public GetChatAdministrators(@NotNull Object chatId) {
        super(GetChatAdministratorsResponse.class);
        if (chatId instanceof Number || chatId instanceof String) {
            addParameter("chat_id", chatId);
        } else {
            throw new WrongParameterTypeException("Type of parameter chatId must be Number or String (if it's chat username)");
        }
    }
}