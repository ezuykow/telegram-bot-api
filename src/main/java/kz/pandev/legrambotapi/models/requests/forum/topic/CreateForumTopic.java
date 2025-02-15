package kz.pandev.legrambotapi.models.requests.forum.topic;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.common.CreateForumTopicResponse;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to create a topic in a forum supergroup chat. The bot must be an administrator in the
 * chat for this to work and must have the can_manage_topics administrator rights. Returns information
 * about the created topic as a ForumTopic object.
 * @author ezuykow
 */
public class CreateForumTopic extends Request<CreateForumTopic, CreateForumTopicResponse> {

    /**
     * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroupusername)
     * @param name Topic name, 1-128 characters
     */
    public CreateForumTopic(@NotNull Object chatId, @NotNull String name) {
        super(CreateForumTopicResponse.class);
        if (chatId instanceof Number || chatId instanceof String) {
            addParameter("chat_id", chatId);
            addParameter("name", name);
        } else {
            throw new WrongParameterTypeException("Type of parameter chatId must be Number or String (if it's chat username)");
        }
    }

    //region API

    /**
     * Set parameter icon_color
     * @param iconColor Color of the topic icon in RGB format. Currently, must be one of 7322096 (0x6FB9F0),
     *                 16766590 (0xFFD67E), 13338331 (0xCB86DB), 9367192 (0x8EEE98), 16749490 (0xFF93B2), or
     *                 16478047 (0xFB6F5F)
     * @return this request
     */
    public CreateForumTopic iconColor(int iconColor) {
        return addParameter("icon_color", iconColor);
    }

    /**
     * Set parameter icon_custom_emoji_id
     * @param iconCustomEmojiId Unique identifier of the custom emoji shown as the topic icon. Use
     *                          getForumTopicIconStickers to get all allowed custom emoji identifiers.
     * @return this request
     */
    public CreateForumTopic iconCustomEmojiId(@NotNull String iconCustomEmojiId) {
        return addParameter("icon_custom_emoji_id", iconCustomEmojiId);
    }

    //endregion
}