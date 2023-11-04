package kz.pandev.legrambotapi.models.requests.common.send;

import kz.pandev.legrambotapi.models.requests.AbstractSendRequest;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Use this method to send information about a venue. On success, the sent Message is returned.
 * @author ezuykow
 */
@Getter
public class SendVenue extends AbstractSendRequest<SendVenue> {

    /**
     * Foursquare identifier of the venue
     */
    @Nullable
    private String foursquareId;
    /**
     * Foursquare type of the venue, if known.
     * (For example, “arts_entertainment/default”, “arts_entertainment/aquarium” or “food/icecream”.)
     */
    @Nullable
    private String foursquareType;
    /**
     * Google Places identifier of the venue
     */
    @Nullable
    private String googlePlaceId;
    /**
     * Google Places type of the venue.
     */
    @Nullable
    private String googlePlaceType;

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param latitude Latitude of the venue
     * @param longitude Longitude of the venue
     * @param title Name of the venue
     * @param address Address of the venue
     */
    public SendVenue(@NotNull Object chatId, float latitude, float longitude, @NotNull String title,
                     @NotNull String address) {
        super(chatId);
        addParameter("latitude", latitude);
        addParameter("longitude", longitude);
        addParameter("title", title);
        addParameter("address", address);
    }

    //region API

    /**
     * Set parameter {@link SendVenue#foursquareId}
     * @param foursquareId new parameter value
     * @return this request
     */
    public SendVenue foursquareId(@NotNull String foursquareId) {
        this.foursquareId = foursquareId;
        return addParameter("foursquare_id", foursquareId);
    }

    /**
     * Set parameter {@link SendVenue#foursquareType}
     * @param foursquareType new parameter value
     * @return this request
     */
    public SendVenue foursquareType(@NotNull String foursquareType) {
        this.foursquareType = foursquareType;
        return addParameter("foursquare_type", foursquareType);
    }

    /**
     * Set parameter {@link SendVenue#googlePlaceId}
     * @param googlePlaceId new parameter value
     * @return this request
     */
    public SendVenue googlePlaceId(@NotNull String googlePlaceId) {
        this.googlePlaceId = googlePlaceId;
        return addParameter("google_place_id", googlePlaceId);
    }

    /**
     * Set parameter {@link SendVenue#googlePlaceType}
     * @param googlePlaceType new parameter value
     * @return this request
     */
    public SendVenue googlePlaceType(@NotNull String googlePlaceType) {
        this.googlePlaceType = googlePlaceType;
        return addParameter("google_place_type", googlePlaceType);
    }

    //endregion
}