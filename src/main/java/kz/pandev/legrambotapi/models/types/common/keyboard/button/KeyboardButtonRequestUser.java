package kz.pandev.legrambotapi.models.types.common.keyboard.button;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object defines the criteria used to request a suitable user. The identifier of the selected user will
 * be shared with the bot when the corresponding button is pressed
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class KeyboardButtonRequestUser implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Signed 32-bit identifier of the request, which will be received back in the UserShared object.
     * Must be unique within the message
     */
    @SerializedName("request_id")
    private Integer requestId;

    /**
     * Optional. Pass True to request a bot, pass False to request a regular user.
     * If not specified, no additional restrictions are applied.
     */
    @SerializedName("user_is_bot")
    @Nullable
    private Boolean userIsBot;

    /**
     * Optional. Pass True to request a premium user, pass False to request a non-premium user.
     * If not specified, no additional restrictions are applied.
     */
    @SerializedName("user_is_premium")
    @Nullable
    private Boolean userIsPremium;
}