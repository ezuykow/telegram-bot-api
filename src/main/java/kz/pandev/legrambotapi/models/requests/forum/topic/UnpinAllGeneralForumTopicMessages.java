package kz.pandev.legrambotapi.models.requests.forum.topic;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to clear the list of pinned messages in a General forum topic.
 * The bot must be an administrator in the chat for this to work and must have the can_pin_messages
 * administrator right in the supergroup. Returns True on success.
 * @author ezuykow
 */
public class UnpinAllGeneralForumTopicMessages extends Request<UnpinAllGeneralForumTopicMessages, Response> {

    /**
     * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroupusername)
     */
    public UnpinAllGeneralForumTopicMessages(@NotNull Object chatId) {
        super(Response.class);
        if (chatId instanceof Number || chatId instanceof String) {
            addParameter("chat_id", chatId);
        } else {
            throw new WrongParameterTypeException("Type of parameter chatId must be Number or String (if it's chat username)");
        }
    }
}