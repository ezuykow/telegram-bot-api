package kz.pandev.legrambotapi.models.requests.common;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to decline a chat join request. The bot must be an administrator
 * in the chat for this to work and must have the can_invite_users administrator right. Returns True on success.
 * @author ezuykow
 */
public class DeclineChatJoinRequest extends Request<DeclineChatJoinRequest, Response> {

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param userId Unique identifier of the target user
     */
    public DeclineChatJoinRequest(@NotNull Object chatId, long userId) {
        super(Response.class);
        if (chatId instanceof Number || chatId instanceof String) {
            addParameter("chat_id", chatId);
            addParameter("user_id", userId);
        } else {
            throw new WrongParameterTypeException("Type of parameter chatId must be Number or String (if it's chat username)");
        }
    }
}