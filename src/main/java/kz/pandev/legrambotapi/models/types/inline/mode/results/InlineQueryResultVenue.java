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
 * Represents a venue. By default, the venue will be sent by the user.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the venue.
 * @author ezuykow
 */
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@ToString
public class InlineQueryResultVenue extends InlineQueryResult<InlineQueryResultVenue> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private static final String INLINE_QUERY_RESULT_TYPE = "venue";

    /**
     * Latitude of the venue location in degrees
     */
    @SerializedName("latitude")
    private Float latitude;

    /**
     * Longitude of the venue location in degrees
     */
    @SerializedName("longitude")
    private Float longitude;

    /**
     * Address of the venue
     */
    @SerializedName("address")
    private String address;

    /**
     * Optional. Foursquare identifier of the venue if known
     */
    @SerializedName("foursquare_id")
    @Nullable
    private String foursquareId;

    /**
     * Optional. Foursquare type of the venue, if known. (For example, “arts_entertainment/default”,
     * “arts_entertainment/aquarium” or “food/icecream”.)
     */
    @SerializedName("foursquare_type")
    @Nullable
    private String foursquareType;

    /**
     * Optional. Google Places identifier of the venue
     */
    @SerializedName("google_place_id")
    @Nullable
    private String googlePlaceId;

    /**
     * Optional. Google Places type of the venue
     */
    @SerializedName("google_place_type")
    @Nullable
    private String googlePlaceType;

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

    public InlineQueryResultVenue(@NotNull String id, float latitude, float longitude,
                                  @NotNull String title, @NotNull String address) {
        super(INLINE_QUERY_RESULT_TYPE, id);
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        title(title);
    }

    //region API

    /**
     * Set parameter {@link InlineQueryResultVenue#latitude}
     * @param latitude new parameter value
     * @return this {@link InlineQueryResultVenue}
     */
    public InlineQueryResultVenue latitude(Float latitude) {
        this.latitude = latitude;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultVenue#longitude}
     * @param longitude new parameter value
     * @return this {@link InlineQueryResultVenue}
     */
    public InlineQueryResultVenue longitude(Float longitude) {
        this.longitude = longitude;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultVenue#address}
     * @param address new parameter value
     * @return this {@link InlineQueryResultVenue}
     */
    public InlineQueryResultVenue address(String address) {
        this.address = address;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultVenue#foursquareId}
     * @param foursquareId new parameter value
     * @return this {@link InlineQueryResultVenue}
     */
    public InlineQueryResultVenue foursquareId(String foursquareId) {
        this.foursquareId = foursquareId;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultVenue#foursquareType}
     * @param foursquareType new parameter value
     * @return this {@link InlineQueryResultVenue}
     */
    public InlineQueryResultVenue foursquareType(String foursquareType) {
        this.foursquareType = foursquareType;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultVenue#googlePlaceId}
     * @param googlePlaceId new parameter value
     * @return this {@link InlineQueryResultVenue}
     */
    public InlineQueryResultVenue googlePlaceId(String googlePlaceId) {
        this.googlePlaceId = googlePlaceId;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultVenue#googlePlaceType}
     * @param googlePlaceType new parameter value
     * @return this {@link InlineQueryResultVenue}
     */
    public InlineQueryResultVenue googlePlaceType(String googlePlaceType) {
        this.googlePlaceType = googlePlaceType;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultVenue#thumbnailUrl}
     * @param thumbnailUrl new parameter value
     * @return this {@link InlineQueryResultVenue}
     */
    public InlineQueryResultVenue thumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultVenue#thumbnailWidth}
     * @param thumbnailWidth new parameter value
     * @return this {@link InlineQueryResultVenue}
     */
    public InlineQueryResultVenue thumbnailWidth(Integer thumbnailWidth) {
        this.thumbnailWidth = thumbnailWidth;
        return this;
    }

    /**
     * Set parameter {@link InlineQueryResultVenue#thumbnailHeight}
     * @param thumbnailHeight new parameter value
     * @return this {@link InlineQueryResultVenue}
     */
    public InlineQueryResultVenue thumbnailHeight(Integer thumbnailHeight) {
        this.thumbnailHeight = thumbnailHeight;
        return this;
    }

    //endregion
}