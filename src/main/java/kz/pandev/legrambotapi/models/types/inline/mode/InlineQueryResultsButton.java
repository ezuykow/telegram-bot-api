package kz.pandev.legrambotapi.models.types.inline.mode;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.common.web.app.WebAppInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object represents a button to be shown above inline query results.
 * You must use exactly one of the optional fields.
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class InlineQueryResultsButton implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Label text on the button
     */
    @SerializedName("text")
    private String text;

    /**
     * Optional. Description of the Web App that will be launched when the user presses the button.
     * The Web App will be able to switch back to the inline mode using the method switchInlineQuery
     * inside the Web App.
     */
    @SerializedName("web_app")
    @Nullable
    private WebAppInfo webApp;

    /**
     * Optional. <a href="https://core.telegram.org/bots/features#deep-linking">Deep-linking</a> parameter for the /start message sent to the bot when a user presses the button.
     * 1-64 characters, only A-Z, a-z, 0-9, _ and - are allowed.
     * @apiNote Example: An inline bot that sends YouTube videos can ask the user to connect the bot
     * to their YouTube account to adapt search results accordingly. To do this, it displays a
     * 'Connect your YouTube account' button above the results, or even before showing any. The user presses
     * the button, switches to a private chat with the bot and, in doing so, passes a start parameter that
     * instructs the bot to return an OAuth link. Once done, the bot can offer a switch_inline button so that
     * the user can easily return to the chat where they wanted to use the bot's inline capabilities.
     */
    @SerializedName("start_parameter")
    @Nullable
    private String startParameter;
}