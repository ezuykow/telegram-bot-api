package kz.pandev.legrambotapi.models.requests.common.unban;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to unban a previously banned channel chat in a supergroup or channel.
 * The bot must be an administrator for this to work and must have the appropriate administrator rights.
 * Returns True on success.
 * @author ezuykow
 */
public class UnbanChatSenderChat extends Request<UnbanChatSenderChat, Response> {

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param senderChatId Unique identifier of the target sender chat
     */
    public UnbanChatSenderChat(@NotNull Object chatId, long senderChatId) {
        super(Response.class);
        if (chatId instanceof Number || chatId instanceof String) {
            addParameter("chat_id", chatId);
            addParameter("sender_chat_id", senderChatId);
        } else {
            throw new WrongParameterTypeException("Type of parameter chatId must be Number or String (if it's chat username)");
        }
    }
}