package kz.pandev.legrambotapi.models.types.common.inline.keyboard;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.common.LoginUrl;
import kz.pandev.legrambotapi.models.types.common.SwitchInlineQueryChosenChat;
import kz.pandev.legrambotapi.models.types.common.web.app.WebAppInfo;
import kz.pandev.legrambotapi.models.types.games.CallbackGame;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object represents one button of an inline keyboard. You must use exactly one of the optional fields.
 * @author ezuykow
 */
@Getter
@EqualsAndHashCode
@ToString
public class InlineKeyboardButton implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Label text on the button
     */
    @SerializedName("text")
    private String text;

    /**
     * Optional. HTTP or tg:// URL to be opened when the button is pressed.
     * Links tg://user?id=<user_id> can be used to mention a user by their ID without using a username,
     * if this is allowed by their privacy settings.
     */
    @SerializedName("url")
    @Nullable
    private String url;

    /**
     * Optional. Data to be sent in a callback query to the bot when button is pressed, 1-64 bytes
     */
    @SerializedName("callback_data")
    @Nullable
    private String callbackData;

    /**
     * Optional. Description of the <a href="https://core.telegram.org/bots/webapps">Web App</a> that will
     * be launched when the user presses the button. The Web App will be able to send an arbitrary message
     * on behalf of the user using the method answerWebAppQuery. Available only in private chats between
     * a user and the bot.
     */
    @SerializedName("web_app")
    @Nullable
    private WebAppInfo webApp;

    /**
     * Optional. An HTTPS URL used to automatically authorize the user. Can be used as a replacement
     * for the <a href="https://core.telegram.org/widgets/login">Telegram Login Widget</a>.
     */
    @SerializedName("login_url")
    @Nullable
    private LoginUrl loginUrl;

    /**
     * Optional. If set, pressing the button will prompt the user to select one of their chats,
     * open that chat and insert the bot's username and the specified inline query in the input field.
     * May be empty, in which case just the bot's username will be inserted.
     */
    @SerializedName("switch_inline_query")
    @Nullable
    private String switchInlineQuery;

    /**
     * Optional. If set, pressing the button will insert the bot's username and the specified inline query
     * in the current chat's input field. May be empty, in which case only the bot's username will be
     * inserted. <br>
     * This offers a quick way for the user to open your bot in inline mode in the same chat - good for
     * selecting something from multiple options.
     */
    @SerializedName("switch_inline_query_current_chat")
    @Nullable
    private String switchInlineQueryCurrentChat;

    /**
     * Optional. If set, pressing the button will prompt the user to select one of their chats of
     * the specified type, open that chat and insert the bot's username and the specified inline query
     * in the input field
     */
    @SerializedName("switch_inline_query_chosen_chat")
    @Nullable
    private SwitchInlineQueryChosenChat switchInlineQueryChosenChat;

    /**
     * Optional. Description of the game that will be launched when the user presses the button. <br>
     * NOTE: This type of button must always be the first button in the first row.
     */
    @SerializedName("callback_game")
    @Nullable
    private CallbackGame callbackGame;

    /**
     * Optional. Specify True, to send a Pay button. <br>
     * NOTE: This type of button must always be the first button in the first row and can only be used
     * in invoice messages.
     */
    @SerializedName("pay")
    @Nullable
    private Boolean pay;

    public InlineKeyboardButton(@NotNull String text) {
        this.text = text;
        this.callbackData = text;
    }

    //region API

    /**
     * Set parameter {@link InlineKeyboardButton#url}
     * @param url new parameter value
     * @return this
     */
    public InlineKeyboardButton url(@NotNull String url) {
        this.callbackData = null;
        this.url = url;
        return this;
    }

    /**
     * Set parameter {@link InlineKeyboardButton#callbackData}
     * @param callbackData new parameter value
     * @return this
     */
    public InlineKeyboardButton callbackData(@NotNull String callbackData) {
        this.callbackData = callbackData;
        return this;
    }

    /**
     * Set parameter {@link InlineKeyboardButton#webApp}
     * @param webApp new parameter value
     * @return this
     */
    public InlineKeyboardButton webApp(@NotNull WebAppInfo webApp) {
        this.callbackData = null;
        this.webApp = webApp;
        return this;
    }

    /**
     * Set parameter {@link InlineKeyboardButton#loginUrl}
     * @param loginUrl new parameter value
     * @return this
     */
    public InlineKeyboardButton loginUrl(@NotNull LoginUrl loginUrl) {
        this.callbackData = null;
        this.loginUrl = loginUrl;
        return this;
    }

    /**
     * Set parameter {@link InlineKeyboardButton#switchInlineQuery}
     * @param switchInlineQuery new parameter value
     * @return this
     */
    public InlineKeyboardButton switchInlineQuery(@NotNull String switchInlineQuery) {
        this.callbackData = null;
        this.switchInlineQuery = switchInlineQuery;
        return this;
    }

    /**
     * Set parameter {@link InlineKeyboardButton#switchInlineQueryCurrentChat}
     * @param switchInlineQueryCurrentChat new parameter value
     * @return this
     */
    public InlineKeyboardButton switchInlineQueryCurrentChat(@NotNull String switchInlineQueryCurrentChat) {
        this.callbackData = null;
        this.switchInlineQueryCurrentChat = switchInlineQueryCurrentChat;
        return this;
    }

    /**
     * Set parameter {@link InlineKeyboardButton#switchInlineQueryChosenChat}
     * @param switchInlineQueryChosenChat new parameter value
     * @return this
     */
    public InlineKeyboardButton switchInlineQueryChosenChat(@NotNull SwitchInlineQueryChosenChat switchInlineQueryChosenChat) {
        this.callbackData = null;
        this.switchInlineQueryChosenChat = switchInlineQueryChosenChat;
        return this;
    }

    /**
     * Set parameter {@link InlineKeyboardButton#callbackGame}
     * @param callbackGame new parameter value
     * @return this
     */
    public InlineKeyboardButton callbackGame(@NotNull CallbackGame callbackGame) {
        this.callbackData = null;
        this.callbackGame = callbackGame;
        return this;
    }

    /**
     * Set parameter {@link InlineKeyboardButton#pay}
     * @param pay new parameter value
     * @return this
     */
    public InlineKeyboardButton pay(boolean pay) {
        this.callbackData = null;
        this.pay = pay;
        return this;
    }

    //endregion
}