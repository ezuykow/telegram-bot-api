package kz.pandev.legrambotapi.models.types.forum;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object represents a service message about a new forum topic created in the chat
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ForumTopicCreated implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

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