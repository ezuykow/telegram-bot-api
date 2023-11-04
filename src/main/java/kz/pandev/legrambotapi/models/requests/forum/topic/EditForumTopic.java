package kz.pandev.legrambotapi.models.requests.forum.topic;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Use this method to edit name and icon of a topic in a forum supergroup chat. The bot must
 * be an administrator in the chat for this to work and must have can_manage_topics administrator
 * rights, unless it is the creator of the topic. Returns True on success.
 * @author ezuykow
 */
@Getter
public class EditForumTopic extends Request<EditForumTopic, Response> {

    /**
     * Optional. New topic name, 0-128 characters. If not specified or empty, the current name of the topic will be kept
     */
    @Nullable
    private String name;
    /**
     * Optional. New unique identifier of the custom emoji shown as the topic icon.
     * Use getForumTopicIconStickers to get all allowed custom emoji identifiers.
     * Pass an empty string to remove the icon. If not specified, the current icon will be kept
     */
    @Nullable
    private String iconCustomEmojiId;

    /**
     * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroupusername)
     * @param messageThreadId Unique identifier for the target message thread of the forum topic
     */
    public EditForumTopic(@NotNull Object chatId, @NotNull Integer messageThreadId) {
        super(Response.class);
        if (chatId instanceof Number || chatId instanceof String) {
            addParameter("chat_id", chatId);
            addParameter("message_thread_id", messageThreadId);
        } else {
            throw new WrongParameterTypeException("Type of parameter chatId must be Number or String (if it's chat username)");
        }
    }

    //region API

    /**
     * Set parameter {@link EditForumTopic#name}
     * @param name new parameter value
     * @return this request
     */
    public EditForumTopic name(String name) {
        this.name = name;
        return addParameter("name", name);
    }

    /**
     * Set parameter {@link EditForumTopic#iconCustomEmojiId}
     * @param iconCustomEmojiId new parameter value
     * @return this request
     */
    public EditForumTopic iconCustomEmojiId(String iconCustomEmojiId) {
        this.iconCustomEmojiId = iconCustomEmojiId;
        return addParameter("icon_custom_emoji_id", iconCustomEmojiId);
    }

    //endregion
}