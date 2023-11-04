package kz.pandev.legrambotapi.models.requests.common.set;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to change the description of a group, a supergroup or a channel.
 * The bot must be an administrator in the chat for this to work and must have the appropriate
 * administrator rights. Returns True on success.
 * @author ezuykow
 */
public class SetChatDescription extends Request<SetChatDescription, Response> {

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param description New chat description, 0-255 characters
     */
    public SetChatDescription(@NotNull Object chatId, @NotNull String description) {
        super(Response.class);
        if (chatId instanceof Number || chatId instanceof String) {
            addParameter("chat_id", chatId);
            addParameter("description", description);
        } else {
            throw new WrongParameterTypeException("Type of parameter chatId must be Number or String (if it's chat username)");
        }
    }
}