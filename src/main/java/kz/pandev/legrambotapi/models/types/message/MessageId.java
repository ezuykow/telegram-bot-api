package kz.pandev.legrambotapi.models.types.message;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object represents a unique message identifier
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class MessageId implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Unique message identifier
     */
    @SerializedName("message_id")
    private Integer id;
}