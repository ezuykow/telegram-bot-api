package kz.pandev.legrambotapi.models.types.common;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object represents a parameter of the inline keyboard button used to automatically authorize a user.
 * Serves as a great replacement for the Telegram Login Widget when the user is coming from Telegram.
 * All the user needs to do is tap/click a button and confirm that they want to log in.
 * Telegram apps support these buttons as of version 5.7.
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class LoginUrl implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * An HTTPS URL to be opened with user authorization data added to the query string when the button is
     * pressed. If the user refuses to provide authorization data, the original URL without information
     * about the user will be opened. The data added is the same as described in
     * <a href="https://core.telegram.org/widgets/login#receiving-authorization-data">Receiving authorization data</a>.
     * <br>
     * NOTE: You must always check the hash of the received data to verify the authentication and the integrity
     * of the data as described in
     * <a href="https://core.telegram.org/widgets/login#checking-authorization">Checking authorization</a>.
     */
    @SerializedName("url")
    private String url;

    /**
     * Optional. New text of the button in forwarded messages.
     */
    @SerializedName("forward_text")
    @Nullable
    private String forwardText;

    /**
     * Optional. Username of a bot, which will be used for user authorization.
     * See <a href="https://core.telegram.org/widgets/login#setting-up-a-bot">Setting up a bot</a> for more details.
     * If not specified, the current bot's username will be assumed.
     * The url's domain must be the same as the domain linked with the bot. See
     * <a href="https://core.telegram.org/widgets/login#linking-your-domain-to-the-bot">Linking your domain</a>
     * to the bot for more details.
     */
    @SerializedName("bot_username")
    @Nullable
    private String botUsername;

    /**
     * Optional. Pass True to request the permission for your bot to send messages to the user.
     */
    @SerializedName("request_write_access")
    @Nullable
    private Boolean requestWriteAccess;
}