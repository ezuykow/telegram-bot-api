package kz.pandev.legrambotapi.models.types.user;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object contains information about the user whose identifier was
 * shared with the bot using a KeyboardButtonRequestUser button
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class UserShared implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Identifier of the request
     */
    @SerializedName("request_id")
    private Integer requestId;

    /**
     * Identifier of the shared user
     */
    @SerializedName("user_id")
    private Long userId;
}