package kz.pandev.legrambotapi.models.types.keyboard_button;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.web_app.WebAppInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object represents one button of the reply keyboard. For simple text buttons, String can be used instead
 * of this object to specify the button text. The optional fields web_app, request_user, request_chat, request_contact,
 * request_location, and request_poll are mutually exclusive.
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class KeyboardButton implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Text of the button. If none of the optional fields are used,
     * it will be sent as a message when the button is pressed
     */
    @SerializedName("text")
    private String text;

    /**
     * Optional. If specified, pressing the button will open a list of suitable users. Tapping on any user will send
     * their identifier to the bot in a “user_shared” service message. Available in private chats only.
     */
    @SerializedName("request_user")
    @Nullable
    private KeyboardButtonRequestUser requestUser;

    /**
     * Optional. If specified, pressing the button will open a list of suitable chats. Tapping on a chat will send
     * its identifier to the bot in a “chat_shared” service message. Available in private chats only.
     */
    @SerializedName("request_chat")
    @Nullable
    private KeyboardButtonRequestChat requestChat;

    /**
     * Optional. If True, the user's phone number will be sent as a contact when the button is pressed.
     * Available in private chats only.
     */
    @SerializedName("request_contact")
    @Nullable
    private Boolean requestContact;

    /**
     * Optional. If True, the user's current location will be sent when the button is pressed.
     * Available in private chats only.
     */
    @SerializedName("request_location")
    @Nullable
    private Boolean requestLocation;

    /**
     * Optional. If specified, the user will be asked to create a poll and send it to the bot when the button
     * is pressed. Available in private chats only.
     */
    @SerializedName("request_poll")
    @Nullable
    private KeyboardButtonPollType requestPoll;

    /**
     * Optional. If specified, the described Web App will be launched when the button is pressed.
     * The Web App will be able to send a “web_app_data” service message. Available in private chats only.
     */
    @SerializedName("web_app")
    @Nullable
    private WebAppInfo webApp;
}