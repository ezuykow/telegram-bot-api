package kz.pandev.legrambotapi.models.types.common;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.common.message.Message;
import kz.pandev.legrambotapi.models.types.common.user.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object represents an incoming callback query from a callback button in an
 * inline keyboard. If the button that originated the query was attached to a message sent by the bot,
 * the field message will be present. If the button was attached to a message sent via the bot
 * (in inline mode), the field inline_message_id will be present. Exactly one of the fields data or
 * game_short_name will be present.
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class CallbackQuery implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Unique identifier for this query
     */
    @SerializedName("id")
    @EqualsAndHashCode.Include
    private String id;

    /**
     * Sender
     */
    @SerializedName("from")
    private User from;

    /**
     * Optional. Message with the callback button that originated the query.
     * Note that message content and message date will not be available if the message is too old
     */
    @SerializedName("message")
    @Nullable
    private Message message;

    /**
     * Optional. Identifier of the message sent via the bot in inline mode, that originated the query.
     */
    @SerializedName("inline_message_id")
    @Nullable
    private String inlineMessageId;

    /**
     * Global identifier, uniquely corresponding to the chat to which the message with the callback
     * button was sent. Useful for high scores in games.
     */
    @SerializedName("chat_instance")
    @Nullable
    private String chatInstance;

    /**
     * Optional. Data associated with the callback button. Be aware that the message originated
     * the query can contain no callback buttons with this data.
     */
    @SerializedName("data")
    @Nullable
    private String data;

    /**
     * Optional. Short name of a <a href="https://core.telegram.org/bots/api#games">Game</a> to be returned, serves as the unique identifier for the game
     */
    @SerializedName("game_short_name")
    @Nullable
    private String gameShortName;
}