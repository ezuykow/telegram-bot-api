package kz.pandev.legrambotapi.models.types.inline.mode;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;

/**
 * Describes an inline message sent by a Web App on behalf of a user.
 * @author ezuykow
 */
@Getter
@EqualsAndHashCode
@ToString
public class SentWebAppMessage implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Optional. Identifier of the sent inline message. Available only if there is an inline keyboard
     * attached to the message.
     */
    @SerializedName("inline_message_id")
    @Nullable
    private String inlineMessageId;

    public SentWebAppMessage() {
        this(null);
    }

    public SentWebAppMessage(@Nullable String inlineMessageId) {
        this.inlineMessageId = inlineMessageId;
    }
}