package kz.pandev.legrambotapi.models.requests.common.send;

import kz.pandev.legrambotapi.models.requests.AbstractSendRequest;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to send information about a venue. On success, the sent Message is returned.
 * @author ezuykow
 */
public class SendVenue extends AbstractSendRequest<SendVenue> {

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
     * Set parameter foursquare_id
     * @param foursquareId Foursquare identifier of the venue
     * @return this request
     */
    public SendVenue foursquareId(@NotNull String foursquareId) {
        return addParameter("foursquare_id", foursquareId);
    }

    /**
     * Set parameter foursquare_type
     * @param foursquareType Foursquare type of the venue, if known. (For example, “arts_entertainment/default”,
     *                      “arts_entertainment/aquarium” or “food/icecream”.)
     * @return this request
     */
    public SendVenue foursquareType(@NotNull String foursquareType) {
        return addParameter("foursquare_type", foursquareType);
    }

    /**
     * Set parameter google_place_id
     * @param googlePlaceId Google Places identifier of the venue
     * @return this request
     */
    public SendVenue googlePlaceId(@NotNull String googlePlaceId) {
        return addParameter("google_place_id", googlePlaceId);
    }

    /**
     * Set parameter google_place_type
     * @param googlePlaceType Google Places type of the venue.
     * @return this request
     */
    public SendVenue googlePlaceType(@NotNull String googlePlaceType) {
        return addParameter("google_place_type", googlePlaceType);
    }

    //endregion
}