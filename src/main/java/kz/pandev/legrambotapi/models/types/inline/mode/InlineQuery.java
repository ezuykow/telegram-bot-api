package kz.pandev.legrambotapi.models.types.inline.mode;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.common.Location;
import kz.pandev.legrambotapi.models.types.common.user.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object represents an incoming inline query. When the user sends an empty query,
 * your bot could return some default or trending results.
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class InlineQuery implements Serializable {

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
     * Text of the query (up to 256 characters)
     */
    @SerializedName("query")
    private String query;

    /**
     * Offset of the results to be returned, can be controlled by the bot
     */
    @SerializedName("offset")
    private String offset;

    /**
     * Optional. Type of the chat from which the inline query was sent.
     * Can be either “sender” for a private chat with the inline query sender,
     * “private”, “group”, “supergroup”, or “channel”. The chat type should be always
     * known for requests sent from official clients and most third-party clients,
     * unless the request was sent from a secret chat
     */
    @SerializedName("chat_type")
    @Nullable
    private String chatType;

    /**
     * Optional. Sender location, only for bots that request user location
     */
    @SerializedName("location")
    @Nullable
    private Location location;
}