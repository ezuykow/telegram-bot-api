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
 * Represents a result of an inline query (InlineQueryResult) that was chosen by the user and sent to their chat partner.
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class ChosenInlineResults implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * The unique identifier for the result that was chosen
     */
    @SerializedName("result_id")
    @EqualsAndHashCode.Include
    private String resultId;

    /**
     * The user that chose the result
     */
    @SerializedName("from")
    private User from;

    /**
     * Optional. Sender location, only for bots that require user location
     */
    @SerializedName("location")
    @Nullable
    private Location location;

    /**
     * Optional. Identifier of the sent inline message. Available only if there is an
     * inline keyboard attached to the message. Will be also received in callback queries
     * and can be used to edit the message.
     */
    @SerializedName("inline_message_id")
    @Nullable
    private String inlineMessageId;

    /**
     * The query that was used to obtain the result
     */
    @SerializedName("query")
    @Nullable
    private String query;
}