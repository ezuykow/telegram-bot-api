package kz.pandev.legrambotapi.models.requests.common.edit;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.responses.SendResponse;
import kz.pandev.legrambotapi.models.types.common.inline.keyboard.InlineKeyboardMarkup;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Use this method to edit live location messages. A location can be edited until its live_period
 * expires or editing is explicitly disabled by a call to stopMessageLiveLocation. On success,
 * if the edited message is not an inline message, the edited Message is returned, otherwise True is returned.
 * @author ezuykow
 */
@Getter
public class EditMessageLiveLocation extends Request<EditMessageLiveLocation, Response> {

    /**
     * Optional. The radius of uncertainty for the location, measured in meters; 0-1500
     */
    @Nullable
    private Float horizontalAccuracy;
    /**
     * Optional. Direction in which the user is moving, in degrees. Must be between 1 and 360 if specified.
     */
    @Nullable
    private Integer heading;
    /**
     * Optional. The maximum distance for proximity alerts about approaching another chat member, in meters.
     * Must be between 1 and 100000 if specified.
     */
    @Nullable
    private Integer proximityAlertRadius;
    /**
     * Optional. An inline keyboard.
     */
    @Nullable
    private InlineKeyboardMarkup replyMarkup;

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param messageId Identifier of the message to edit
     * @param latitude Latitude of new location
     * @param longitude Longitude of new location
     */
    public EditMessageLiveLocation(@NotNull Object chatId, int messageId, float latitude, float longitude) {
        super(SendResponse.class);
        if (chatId instanceof Number || chatId instanceof String) {
            addParameter("chat_id", chatId);
            addParameter("message_id", messageId);
            addParameter("latitude", latitude);
            addParameter("longitude", longitude);
        } else {
            throw new WrongParameterTypeException("Type of parameter chatId must be Number or String (if it's chat username)");
        }
    }

    /**
     * @param inlineMessageId Identifier of the inline message
     * @param latitude Latitude of new location
     * @param longitude Longitude of new location
     */
    public EditMessageLiveLocation(@NotNull String inlineMessageId, float latitude, float longitude) {
        super(Response.class);
        addParameter("inline_message_id", inlineMessageId);
        addParameter("latitude", latitude);
        addParameter("longitude", longitude);
    }

    //region API

    /**
     * Set parameter {@link EditMessageLiveLocation#horizontalAccuracy}
     * @param horizontalAccuracy new parameter value
     * @return this request
     */
    public EditMessageLiveLocation horizontalAccuracy(float horizontalAccuracy) {
        this.horizontalAccuracy = horizontalAccuracy;
        return addParameter("horizontal_accuracy", horizontalAccuracy);
    }

    /**
     * Set parameter {@link EditMessageLiveLocation#heading}
     * @param heading new parameter value
     * @return this request
     */
    public EditMessageLiveLocation heading(int heading) {
        this.heading = heading;
        return addParameter("heading", heading);
    }

    /**
     * Set parameter {@link EditMessageLiveLocation#proximityAlertRadius}
     * @param proximityAlertRadius new parameter value
     * @return this request
     */
    public EditMessageLiveLocation proximityAlertRadius(int proximityAlertRadius) {
        this.proximityAlertRadius = proximityAlertRadius;
        return addParameter("proximity_alert_radius", proximityAlertRadius);
    }

    /**
     * Set parameter {@link EditMessageLiveLocation#replyMarkup}
     * @param replyMarkup new parameter value
     * @return this request
     */
    public EditMessageLiveLocation replyMarkup(InlineKeyboardMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
        return addParameter("reply_markup", replyMarkup);
    }

    //endregion
}