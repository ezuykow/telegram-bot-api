package kz.pandev.legrambotapi.models.types.common.message;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object represents a service message about a change in auto-delete timer settings
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class MessageAutoDeleteTimerChanged implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * New auto-delete time for messages in the chat; in seconds
     */
    @SerializedName("message_auto_delete_time")
    private Integer messageAutoDeleteTime;
}