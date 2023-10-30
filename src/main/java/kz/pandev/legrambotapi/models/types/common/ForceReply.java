package kz.pandev.legrambotapi.models.types.common;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;

/**
 * Upon receiving a message with this object, Telegram clients will display a reply interface to the user
 * (act as if the user has selected the bot's message and tapped 'Reply'). This can be extremely useful
 * if you want to create user-friendly step-by-step interfaces without having to sacrifice privacy mode.
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ForceReply implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Shows reply interface to the user, as if they manually selected the bot's message and tapped 'Reply'
     */
    @SerializedName("force_reply")
    private Boolean isForceReply = true;

    /**
     *  Optional. The placeholder to be shown in the input field when the reply is active; 1-64 characters
     */
    @SerializedName("input_field_placeholder")
    @Nullable
    private String inputFieldPlaceholder;

    /**
     * Optional. Use this parameter if you want to force reply from specific users only.
     * Targets: 1) users that are @mentioned in the text of the Message object; 2) if the bot's message
     * is a reply (has reply_to_message_id), sender of the original message.
     */
    @SerializedName("selective")
    @Nullable
    private Boolean selective;
}