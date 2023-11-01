package kz.pandev.legrambotapi.models.types.inline.mode.results;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;

/**
 * Represents a location on a map. By default, the location will be sent by the user.
 * Alternatively, you can use input_message_content to send a message with the specified content instead
 * of the location.
 * @author ezuykow
 */
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@ToString
public class InlineQueryResultLocation extends InlineQueryResult<InlineQueryResultLocation> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private static final String INLINE_QUERY_RESULT_TYPE = "location";

    /**
     * Location latitude in degrees
     */
    @SerializedName("latitude")
    private Float latitude;

    /**
     * Location longitude in degrees
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
     * Optional. For live locations, a maximum distance for proximity alerts about approaching another chat member,
     * in meters. Must be between 1 and 100000 if specified.
     */
    @SerializedName("proximity_alert_radius")
    @Nullable
    private Integer proximityAlertRadius;

    /**
     * Optional. Url of the thumbnail for the result
     */
    @SerializedName("thumbnail_url")
    @Nullable
    private String thumbnailUrl;

    /**
     * Optional. Thumbnail width
     */
    @SerializedName("thumbnail_width")
    @Nullable
    private Integer thumbnailWidth;

    /**
     * Optional. Thumbnail height
     */
    @SerializedName("thumbnail_height")
    @Nullable
    private Integer thumbnailHeight;

    public InlineQueryResultLocation(@NotNull String id, float latitude, float longitude, @NotNull String title) {
        super(INLINE_QUERY_RESULT_TYPE, id);
        this.latitude = latitude;
        this.longitude = longitude;
        title(title);
    }

    //region API

    /**
     * Set parameter {@link InlineQueryResultLocation#latitude}
     * @param latitude new parameter value
     * @return this {@link InlineQueryResultLocation}
     */
    public InlineQueryResultLocation latitude(Float latitude) {
        this.latitude = latitude;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultLocation#longitude}
     * @param longitude new parameter value
     * @return this {@link InlineQueryResultLocation}
     */
    public InlineQueryResultLocation longitude(Float longitude) {
        this.longitude = longitude;
        return this;
    }


    /**
     * Set parameter {@link InlineQueryResultLocation#horizontalAccuracy}
     * @param horizontalAccuracy new parameter value
     * @return this {@link InlineQueryResultLocation}
     */
    public InlineQueryResultLocation horizontalAccuracy(Float horizontalAccuracy) {
        this.horizontalAccuracy = horizontalAccuracy;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultLocation#livePeriod}
     * @param livePeriod new parameter value
     * @return this {@link InlineQueryResultLocation}
     */
    public InlineQueryResultLocation livePeriod(Integer livePeriod) {
        this.livePeriod = livePeriod;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultLocation#heading}
     * @param heading new parameter value
     * @return this {@link InlineQueryResultLocation}
     */
    public InlineQueryResultLocation heading(Integer heading) {
        this.heading = heading;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultLocation#proximityAlertRadius}
     * @param proximityAlertRadius new parameter value
     * @return this {@link InlineQueryResultLocation}
     */
    public InlineQueryResultLocation proximityAlertRadius(Integer proximityAlertRadius) {
        this.proximityAlertRadius = proximityAlertRadius;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultLocation#thumbnailUrl}
     * @param thumbnailUrl new parameter value
     * @return this {@link InlineQueryResultLocation}
     */
    public InlineQueryResultLocation thumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultLocation#thumbnailWidth}
     * @param thumbnailWidth new parameter value
     * @return this {@link InlineQueryResultLocation}
     */
    public InlineQueryResultLocation thumbnailWidth(Integer thumbnailWidth) {
        this.thumbnailWidth = thumbnailWidth;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultLocation#thumbnailHeight}
     * @param thumbnailHeight new parameter value
     * @return this {@link InlineQueryResultLocation}
     */
    public InlineQueryResultLocation thumbnailHeight(Integer thumbnailHeight) {
        this.thumbnailHeight = thumbnailHeight;
        return this;
    }

    //endregion
}