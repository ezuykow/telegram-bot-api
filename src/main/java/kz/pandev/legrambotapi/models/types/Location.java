package kz.pandev.legrambotapi.models.types;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object represents a point on the map
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Location implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Longitude as defined by sender
     */
    @SerializedName("longitude")
    private Float longitude;

    /**
     * Latitude as defined by sender
     */
    @SerializedName("latitude")
    private Float latitude;

    /**
     * Optional. The radius of uncertainty for the location, measured in meters; 0-1500
     */
    @SerializedName("horizontal_accuracy")
    @Nullable
    private Float horizontalAccuracy;

    /**
     * Optional. Time relative to the message sending date, during which the location can be updated; in seconds.
     * For active live locations only
     */
    @SerializedName("live_period")
    @Nullable
    private Integer livePeriod;

    /**
     * Optional. The direction in which user is moving, in degrees; 1-360. For active live locations only
     */
    @SerializedName("heading")
    @Nullable
    private Integer heading;

    /**
     * Optional. The maximum distance for proximity alerts about approaching another chat member, in meters.
     * For sent live locations only
     */
    @SerializedName("proximity_alert_radius")
    @Nullable
    private Integer proximityAlertRadius;
}