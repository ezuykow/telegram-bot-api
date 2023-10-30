package kz.pandev.legrambotapi.models.types.common;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.common.user.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object represents the content of a service message, sent whenever a user in the chat
 * triggers a proximity alert set by another user
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ProximityAlertTriggered implements Serializable {


    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * User that triggered the alert
     */
    @SerializedName("traveler")
    private User traveler;

    /**
     * User that set the alert
     */
    @SerializedName("watcher")
    private User watcher;

    /**
     * The distance between the users
     */
    @SerializedName("distance")
    private Integer distance;
}