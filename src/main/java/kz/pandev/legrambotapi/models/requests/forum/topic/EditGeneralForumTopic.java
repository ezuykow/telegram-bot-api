package kz.pandev.legrambotapi.models.requests.forum.topic;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to edit the name of the 'General' topic in a forum supergroup chat.
 * The bot must be an administrator in the chat for this to work and must have can_manage_topics
 * administrator rights. Returns True on success.
 * @author ezuykow
 */
public class EditGeneralForumTopic extends Request<EditGeneralForumTopic, Response> {

    /**
     * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroupusername)
     * @param name New topic name, 1-128 characters
     */
    public EditGeneralForumTopic(@NotNull Object chatId, @NotNull String name) {
        super(Response.class);
        if (chatId instanceof Number || chatId instanceof String) {
            addParameter("chat_id", chatId);
            addParameter("name", name);
        } else {
            throw new WrongParameterTypeException("Type of parameter chatId must be Number or String (if it's chat username)");
        }
    }
}