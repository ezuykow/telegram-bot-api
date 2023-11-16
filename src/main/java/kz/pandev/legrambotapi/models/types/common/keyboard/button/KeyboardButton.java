package kz.pandev.legrambotapi.models.types.common.keyboard.button;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.common.web.app.WebAppInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
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

    public KeyboardButton(@NotNull String text) {
        this.text = text;
    }

    //region API

    /**
     * Set parameter {@link KeyboardButton#requestUser}
     * @param requestUser new parameter value
     * @return this
     */
    public KeyboardButton requestUser(@NotNull KeyboardButtonRequestUser requestUser) {
        this.requestUser = requestUser;
        return this;
    }

    /**
     * Set parameter {@link KeyboardButton#requestChat}
     * @param requestChat new parameter value
     * @return this
     */
    public KeyboardButton requestChat(@NotNull KeyboardButtonRequestChat requestChat) {
        this.requestChat = requestChat;
        return this;
    }

    /**
     * Set parameter {@link KeyboardButton#requestContact}
     * @param requestContact new parameter value
     * @return this
     */
    public KeyboardButton requestContact(boolean requestContact) {
        this.requestContact = requestContact;
        return this;
    }

    /**
     * Set parameter {@link KeyboardButton#requestLocation}
     * @param requestLocation new parameter value
     * @return this
     */
    public KeyboardButton requestLocation(boolean requestLocation) {
        this.requestLocation = requestLocation;
        return this;
    }

    /**
     * Set parameter {@link KeyboardButton#requestPoll}
     * @param requestPoll new parameter value
     * @return this
     */
    public KeyboardButton requestPoll(@NotNull KeyboardButtonPollType requestPoll) {
        this.requestPoll = requestPoll;
        return this;
    }

    /**
     * Set parameter {@link KeyboardButton#webApp}
     * @param webApp new parameter value
     * @return this
     */
    public KeyboardButton webApp(@NotNull WebAppInfo webApp) {
        this.webApp = webApp;
        return this;
    }

    //endregion
}