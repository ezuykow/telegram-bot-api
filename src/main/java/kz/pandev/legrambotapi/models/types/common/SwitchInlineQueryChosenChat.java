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
 * This object represents an inline button that switches the current user to inline mode in a chosen chat,
 * with an optional default inline query
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class SwitchInlineQueryChosenChat implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Optional. The default inline query to be inserted in the input field. If left empty,
     * only the bot's username will be inserted
     */
    @SerializedName("query")
    @Nullable
    private String query;

    /**
     * Optional. True, if private chats with users can be chosen
     */
    @SerializedName("allow_user_chats")
    @Nullable
    private Boolean allowUserChats;

    /**
     * Optional. True, if private chats with bots can be chosen
     */
    @SerializedName("allow_bot_chats")
    @Nullable
    private Boolean allowBotChats;

    /**
     * Optional. True, if group and supergroup chats can be chosen
     */
    @SerializedName("allow_group_chats")
    @Nullable
    private Boolean allowGroupChats;

    /**
     * Optional. True, if channel chats can be chosen
     */
    @SerializedName("allow_channel_chats")
    @Nullable
    private Boolean allowChannelChats;
}