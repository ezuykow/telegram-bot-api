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
 * Represents the content of a venue message to be sent as the result of an inline query.
 * @author ezuykow
 */
@Getter
@EqualsAndHashCode
@ToString
public class InputVenueMessageContent implements InputMessageContent, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Latitude of the venue in degrees
     */
    @SerializedName("latitude")
    private Float latitude;

    /**
     * Longitude of the venue in degrees
     */
    @SerializedName("longitude")
    private Float longitude;

    /**
     * Name of the venue
     */
    @SerializedName("title")
    private String title;

    /**
     * Address of the venue
     */
    @SerializedName("address")
    private String address;

    /**
     * Optional. Foursquare identifier of the venue, if known
     */
    @SerializedName("foursquare_id")
    @Nullable
    private String foursquareId;

    /**
     * Optional. Foursquare type of the venue, if known.
     * (For example, “arts_entertainment/default”, “arts_entertainment/aquarium” or “food/icecream”.)
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
     * Optional. Google Places type of the venue.
     */
    @SerializedName("google_place_type")
    @Nullable
    private String googlePlaceType;

    public InputVenueMessageContent(@NotNull Float latitude, @NotNull Float longitude,
                                    @NotNull String title, @NotNull String address) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.title = title;
        this.address = address;
    }

    //region API

    /**
     * Set parameter {@link InputVenueMessageContent#latitude}
     * @param latitude new parameter value
     * @return this {@link InputVenueMessageContent}
     */
    public InputVenueMessageContent latitude(Float latitude) {
        this.latitude = latitude;
        return this;
    }

    /**
     * Set parameter {@link InputVenueMessageContent#longitude}
     * @param longitude new parameter value
     * @return this {@link InputVenueMessageContent}
     */
    public InputVenueMessageContent longitude(Float longitude) {
        this.longitude = longitude;
        return this;
    }

    /**
     * Set parameter {@link InputVenueMessageContent#title}
     * @param title new parameter value
     * @return this {@link InputVenueMessageContent}
     */
    public InputVenueMessageContent title(String title) {
        this.title = title;
        return this;
    }

    /**
     * Set parameter {@link InputVenueMessageContent#address}
     * @param address new parameter value
     * @return this {@link InputVenueMessageContent}
     */
    public InputVenueMessageContent address(String address) {
        this.address = address;
        return this;
    }

    /**
     * Set parameter {@link InputVenueMessageContent#foursquareId}
     * @param foursquareId new parameter value
     * @return this {@link InputVenueMessageContent}
     */
    public InputVenueMessageContent foursquareId(String foursquareId) {
        this.foursquareId = foursquareId;
        return this;
    }

    /**
     * Set parameter {@link InputVenueMessageContent#foursquareType}
     * @param foursquareType new parameter value
     * @return this {@link InputVenueMessageContent}
     */
    public InputVenueMessageContent foursquareType(String foursquareType) {
        this.foursquareType = foursquareType;
        return this;
    }

    /**
     * Set parameter {@link InputVenueMessageContent#googlePlaceId}
     * @param googlePlaceId new parameter value
     * @return this {@link InputVenueMessageContent}
     */
    public InputVenueMessageContent googlePlaceId(String googlePlaceId) {
        this.googlePlaceId = googlePlaceId;
        return this;
    }

    /**
     * Set parameter {@link InputVenueMessageContent#googlePlaceType}
     * @param googlePlaceType new parameter value
     * @return this {@link InputVenueMessageContent}
     */
    public InputVenueMessageContent googlePlaceType(String googlePlaceType) {
        this.googlePlaceType = googlePlaceType;
        return this;
    }

    //endregion
}