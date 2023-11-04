package kz.pandev.legrambotapi.models.requests.forum.topic;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to reopen a closed topic in a forum supergroup chat. The bot must be an administrator
 * in the chat for this to work and must have the can_manage_topics administrator rights,
 * unless it is the creator of the topic. Returns True on success.
 * @author ezuykow
 */
public class ReopenForumTopic extends Request<ReopenForumTopic, Response> {

    /**
     * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroupusername)
     * @param messageThreadId Unique identifier for the target message thread of the forum topic
     */
    public ReopenForumTopic(@NotNull Object chatId, int messageThreadId) {
        super(Response.class);
        if (chatId instanceof Number || chatId instanceof String) {
            addParameter("chat_id", chatId);
            addParameter("message_thread_id", messageThreadId);
        } else {
            throw new WrongParameterTypeException("Type of parameter chatId must be Number or String (if it's chat username)");
        }
    }
}