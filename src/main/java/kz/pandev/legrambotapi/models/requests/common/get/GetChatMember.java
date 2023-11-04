package kz.pandev.legrambotapi.models.requests.common.get;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.common.get.GetChatMemberResponse;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to get information about a member of a chat.
 * The method is only guaranteed to work for other users if the bot is an administrator
 * in the chat. Returns a ChatMember object on success.
 * @author ezuykow
 */
public class GetChatMember extends Request<GetChatMember, GetChatMemberResponse> {

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param userId Unique identifier of the target user
     */
    public GetChatMember(@NotNull Object chatId, long userId) {
        super(GetChatMemberResponse.class);
        if (chatId instanceof Number || chatId instanceof String) {
            addParameter("chat_id", chatId);
            addParameter("user_id", userId);
        } else {
            throw new WrongParameterTypeException("Type of parameter chatId must be Number or String (if it's chat username)");
        }
    }
}