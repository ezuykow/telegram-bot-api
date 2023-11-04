package kz.pandev.legrambotapi.models.requests.common.send;

import kz.pandev.legrambotapi.models.requests.AbstractSendRequest;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Use this method to send point on the map. On success, the sent Message is returned.
 * @author ezuykow
 */
@Getter
public class SendLocation extends AbstractSendRequest<SendLocation> {

    /**
     * Optional. The radius of uncertainty for the location, measured in meters; 0-1500
     */
    @Nullable
    private Float horizontalAccuracy;
    /**
     * Optional. Period in seconds for which the location will be updated, should be between 60 and 86400.
     */
    @Nullable
    private Integer livePeriod;
    /**
     * Optional. For live locations, a direction in which the user is moving, in degrees.
     * Must be between 1 and 360 if specified.
     */
    @Nullable
    private Integer heading;
    /**
     * Optional. For live locations, a maximum distance for proximity alerts about approaching
     * another chat member, in meters. Must be between 1 and 100000 if specified.
     */
    @Nullable
    private Integer proximityAlertRadius;

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
     * Set parameter {@link SendLocation#horizontalAccuracy}
     * @param horizontalAccuracy new parameter value
     * @return this request
     */
    public SendLocation horizontalAccuracy(float horizontalAccuracy) {
        this.horizontalAccuracy = horizontalAccuracy;
        return addParameter("horizontal_accuracy", horizontalAccuracy);
    }

    /**
     * Set parameter {@link SendLocation#livePeriod}
     * @param livePeriod new parameter value
     * @return this request
     */
    public SendLocation livePeriod(int livePeriod) {
        this.livePeriod = livePeriod;
        return addParameter("live_period", livePeriod);
    }

    /**
     * Set parameter {@link SendLocation#heading}
     * @param heading new parameter value
     * @return this request
     */
    public SendLocation heading(int heading) {
        this.heading = heading;
        return addParameter("heading", heading);
    }

    /**
     * Set parameter {@link SendLocation#proximityAlertRadius}
     * @param proximityAlertRadius new parameter value
     * @return this request
     */
    public SendLocation proximityAlertRadius(int proximityAlertRadius) {
        this.proximityAlertRadius = proximityAlertRadius;
        return addParameter("proximity_alert_radius", proximityAlertRadius);
    }

    //endregion
}