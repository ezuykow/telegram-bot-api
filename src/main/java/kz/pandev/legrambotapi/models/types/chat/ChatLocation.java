package kz.pandev.legrambotapi.models.types.chat;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.Location;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * Represents a location to which a chat is connected
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ChatLocation implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * The location to which the supergroup is connected. Can't be a live location.
     */
    @SerializedName("location")
    private Location location;

    /**
     * Location address; 1-64 characters, as defined by the chat owner
     */
    @SerializedName("address")
    private String address;
}