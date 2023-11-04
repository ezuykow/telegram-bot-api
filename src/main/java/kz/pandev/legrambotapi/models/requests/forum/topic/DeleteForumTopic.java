package kz.pandev.legrambotapi.models.requests.forum.topic;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to delete a forum topic along with all its messages in a forum supergroup chat.
 * The bot must be an administrator in the chat for this to work and must have the can_delete_messages
 * administrator rights. Returns True on success.
 * @author ezuykow
 */
public class DeleteForumTopic extends Request<DeleteForumTopic, Response> {

    /**
     * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroupusername)
     * @param messageThreadId Unique identifier for the target message thread of the forum topic
     */
    public DeleteForumTopic(@NotNull Object chatId, int messageThreadId) {
        super(Response.class);
        if (chatId instanceof Number || chatId instanceof String) {
            addParameter("chat_id", chatId);
            addParameter("message_thread_id", messageThreadId);
        } else {
            throw new WrongParameterTypeException("Type of parameter chatId must be Number or String (if it's chat username)");
        }
    }
}