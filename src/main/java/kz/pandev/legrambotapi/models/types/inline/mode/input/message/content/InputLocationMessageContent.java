package kz.pandev.legrambotapi.models.types.inline.mode.input.message.content;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;

/**
 * Represents the content of a location message to be sent as the result of an inline query.
 * @author ezuykow
 */
@Getter
@EqualsAndHashCode
@ToString
public class InputLocationMessageContent implements InputMessageContent, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Latitude of the location in degrees
     */
    @SerializedName("latitude")
    private Float latitude;

    /**
     * Longitude of the location in degrees
     */
    @SerializedName("longitude")
    private Float longitude;

    /**
     * Optional. The radius of uncertainty for the location, measured in meters; 0-1500
     */
    @SerializedName("horizontal_accuracy")
    @Nullable
    private Float horizontalAccuracy;

    /**
     * Optional. Period in seconds for which the location can be updated, should be between 60 and 86400.
     */
    @SerializedName("live_period")
    @Nullable
    private Integer livePeriod;

    /**
     * Optional. For live locations, a direction in which the user is moving, in degrees.
     * Must be between 1 and 360 if specified.
     */
    @SerializedName("heading")
    @Nullable
    private Integer heading;

    /**
     * Optional. For live locations, a maximum distance for proximity alerts about approaching
     * another chat member, in meters. Must be between 1 and 100000 if specified.
     */
    @SerializedName("proximity_alert_radius")
    @Nullable
    private Integer proximityAlertRadius;

    public InputLocationMessageContent(@NotNull Float latitude, @NotNull Float longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    //region API

    /**
     * Set parameter {@link InputLocationMessageContent#latitude}
     * @param latitude new parameter value
     * @return this {@link InputLocationMessageContent}
     */
    public InputLocationMessageContent latitude(Float latitude) {
        this.latitude = latitude;
        return this;
    }

    /**
     * Set parameter {@link InputLocationMessageContent#longitude}
     * @param longitude new parameter value
     * @return this {@link InputLocationMessageContent}
     */
    public InputLocationMessageContent longitude(Float longitude) {
        this.longitude = longitude;
        return this;
    }

    /**
     * Set parameter {@link InputLocationMessageContent#horizontalAccuracy}
     * @param horizontalAccuracy new parameter value
     * @return this {@link InputLocationMessageContent}
     */
    public InputLocationMessageContent horizontalAccuracy(Float horizontalAccuracy) {
        this.horizontalAccuracy = horizontalAccuracy;
        return this;
    }

    /**
     * Set parameter {@link InputLocationMessageContent#livePeriod}
     * @param livePeriod new parameter value
     * @return this {@link InputLocationMessageContent}
     */
    public InputLocationMessageContent livePeriod(Integer livePeriod) {
        this.livePeriod = livePeriod;
        return this;
    }

    /**
     * Set parameter {@link InputLocationMessageContent#heading}
     * @param heading new parameter value
     * @return this {@link InputLocationMessageContent}
     */
    public InputLocationMessageContent heading(Integer heading) {
        this.heading = heading;
        return this;
    }

    /**
     * Set parameter {@link InputLocationMessageContent#proximityAlertRadius}
     * @param proximityAlertRadius new parameter value
     * @return this {@link InputLocationMessageContent}
     */
    public InputLocationMessageContent proximityAlertRadius(Integer proximityAlertRadius) {
        this.proximityAlertRadius = proximityAlertRadius;
        return this;
    }

    //endregion
}