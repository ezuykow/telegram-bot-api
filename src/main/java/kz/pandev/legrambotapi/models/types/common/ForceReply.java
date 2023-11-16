package kz.pandev.legrambotapi.models.types.common;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.Keyboard;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
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
@EqualsAndHashCode
@ToString
public class ForceReply implements Keyboard, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Shows reply interface to the user, as if they manually selected the bot's message and tapped 'Reply'
     */
    @SerializedName("force_reply")
    private static final boolean IS_FORCE_REPLY = true;

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

    //region API

    /**
     * Set parameter {@link ForceReply#inputFieldPlaceholder}
     * @param inputFieldPlaceholder new parameter value
     * @return this
     */
    public ForceReply inputFieldPlaceholder(@NotNull String inputFieldPlaceholder) {
        this.inputFieldPlaceholder = inputFieldPlaceholder;
        return this;
    }

    /**
     * Set parameter {@link ForceReply#selective}
     * @param selective new parameter value
     * @return this
     */
    public ForceReply selective(boolean selective) {
        this.selective = selective;
        return this;
    }

    //endregion
}