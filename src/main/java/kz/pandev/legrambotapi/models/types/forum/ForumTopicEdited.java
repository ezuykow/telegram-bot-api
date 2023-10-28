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
 * This object represents a service message about an edited forum topic
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ForumTopicEdited implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Optional. New name of the topic, if it was edited
     */
    @SerializedName("name")
    @Nullable
    private String name;

    /**
     * Optional. New identifier of the custom emoji shown as the topic icon,
     * if it was edited; an empty string if the icon was removed
     */
    @SerializedName("icon_custom_emoji_id")
    @Nullable
    private String iconCustomEmojiId;
}