package kz.pandev.legrambotapi.models.requests.common.send;

import kz.pandev.legrambotapi.models.requests.AbstractSendRequest;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to send point on the map. On success, the sent Message is returned.
 * @author ezuykow
 */
public class SendLocation extends AbstractSendRequest<SendLocation> {

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param latitude Latitude of the location
     * @param longitude Longitude of the location
     */
    public SendLocation(@NotNull Object chatId, float latitude, float longitude) {
        super(chatId);
        addParameter("latitude", latitude);
        addParameter("longitude", longitude);
    }

    //region API

    /**
     * Set parameter horizontal_accuracy
     * @param horizontalAccuracy The radius of uncertainty for the location, measured in meters; 0-1500
     * @return this request
     */
    public SendLocation horizontalAccuracy(float horizontalAccuracy) {
        return addParameter("horizontal_accuracy", horizontalAccuracy);
    }

    /**
     * Set parameter live_period
     * @param livePeriod Period in seconds for which the location will be updated, should be between 60 and 86400.
     * @return this request
     */
    public SendLocation livePeriod(int livePeriod) {
        return addParameter("live_period", livePeriod);
    }

    /**
     * Set parameter heading
     * @param heading For live locations, a direction in which the user is moving, in degrees.
     *               Must be between 1 and 360 if specified.
     * @return this request
     */
    public SendLocation heading(int heading) {
        return addParameter("heading", heading);
    }

    /**
     * Set parameter proximity_alert_radius
     * @param proximityAlertRadius For live locations, a maximum distance for proximity alerts about approaching
     *                            another chat member, in meters. Must be between 1 and 100000 if specified.
     * @return this request
     */
    public SendLocation proximityAlertRadius(int proximityAlertRadius) {
        return addParameter("proximity_alert_radius", proximityAlertRadius);
    }

    //endregion
}