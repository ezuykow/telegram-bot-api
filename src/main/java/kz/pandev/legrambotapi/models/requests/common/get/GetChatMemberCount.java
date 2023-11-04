package kz.pandev.legrambotapi.models.requests.common.get;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.common.get.GetChatMemberCountResponse;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to get the number of members in a chat. Returns Int on success.
 * @author ezuykow
 */
public class GetChatMemberCount extends Request<GetChatMemberCount, GetChatMemberCountResponse> {

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     */
    public GetChatMemberCount(@NotNull Object chatId) {
        super(GetChatMemberCountResponse.class);
        if (chatId instanceof Number || chatId instanceof String) {
            addParameter("chat_id", chatId);
        } else {
            throw new WrongParameterTypeException("Type of parameter chatId must be Number or String (if it's chat username)");
        }
    }
}