package kz.pandev.legrambotapi.models.types.common.forum;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object represents a forum topic.
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ForumTopic implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Unique identifier of the forum topic
     */
    @SerializedName("message_thread_id")
    private Integer messageThreadId;

    /**
     * Name of the topic
     */
    @SerializedName("name")
    private String name;

    /**
     * Color of the topic icon in RGB format
     */
    @SerializedName("icon_color")
    private Integer iconColor;

    /**
     * Optional. Unique identifier of the custom emoji shown as the topic icon
     */
    @SerializedName("icon_custom_emoji_id")
    @Nullable
    private String iconCustomEmojiId;
}