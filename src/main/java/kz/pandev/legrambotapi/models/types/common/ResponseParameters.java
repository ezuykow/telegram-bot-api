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
 * Describes why a request was unsuccessful.
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ResponseParameters implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Optional. The group has been migrated to a supergroup with the specified identifier.
     */
    @SerializedName("migrate_to_chat_id")
    @Nullable
    private Long migrateToChatId;

    /**
     * Optional. In case of exceeding flood control, the number of seconds left to wait
     * before the request can be repeated
     */
    @SerializedName("retry_after")
    @Nullable
    private Integer retryAfter;
}