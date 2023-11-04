package kz.pandev.legrambotapi.models.requests.common.set;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to change the title of a chat. Titles can't be changed for private chats.
 * The bot must be an administrator in the chat for this to work and must have the appropriate
 * administrator rights. Returns True on success.
 * @author ezuykow
 */
public class SetChatTitle extends Request<SetChatTitle, Response> {

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param title New chat title, 1-128 characters
     */
    public SetChatTitle(@NotNull Object chatId, @NotNull String title) {
        super(Response.class);
        if (chatId instanceof Number || chatId instanceof String) {
            addParameter("chat_id", chatId);
            addParameter("title", title);
        } else {
            throw new WrongParameterTypeException("Type of parameter chatId must be Number or String (if it's chat username)");
        }
    }
}