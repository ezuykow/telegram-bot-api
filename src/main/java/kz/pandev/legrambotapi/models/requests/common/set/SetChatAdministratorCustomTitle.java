package kz.pandev.legrambotapi.models.requests.common.set;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to set a custom title for an administrator in a supergroup promoted
 * by the bot. Returns True on success.
 * @author ezuykow
 */
public class SetChatAdministratorCustomTitle extends Request<SetChatAdministratorCustomTitle, Response> {

    /**
     * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroupusername)
     * @param userId Unique identifier of the target user
     * @param customTitle New custom title for the administrator; 0-16 characters, emoji are not allowed
     */
    public SetChatAdministratorCustomTitle(@NotNull Object chatId, long userId, @NotNull String customTitle) {
        super(Response.class);
        if (chatId instanceof Number || chatId instanceof String) {
            addParameter("chat_id", chatId);
            addParameter("user_id", userId);
            addParameter("custom_title", customTitle);
        } else {
            throw new WrongParameterTypeException("Type of parameter chatId must be Number or String (if it's chat username)");
        }
    }
}