package kz.pandev.legrambotapi.models.types.common;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.common.Location;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object represents a venue
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Venue implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Venue location. Can't be a live location
     */
    @SerializedName("location")
    private Location location;

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
     * Optional. Foursquare identifier of the venue
     */
    @SerializedName("foursquare_id")
    @Nullable
    private String foursquareId;

    /**
     * Optional. Foursquare type of the venue.
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
     * Optional. Google Places type of the venue
     */
    @SerializedName("google_place_type")
    @Nullable
    private String googlePlaceType;
}