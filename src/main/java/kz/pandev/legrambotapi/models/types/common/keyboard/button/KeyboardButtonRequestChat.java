package kz.pandev.legrambotapi.models.types.common.keyboard.button;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.common.chat.ChatAdministratorRights;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object defines the criteria used to request a suitable chat. The identifier of the selected chat will
 * be shared with the bot when the corresponding button is pressed
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class KeyboardButtonRequestChat implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Signed 32-bit identifier of the request, which will be received back in the ChatShared object.
     * Must be unique within the message
     */
    @SerializedName("request_id")
    private Integer requestId;

    /**
     * Pass True to request a channel chat, pass False to request a group or a supergroup chat
     */
    @SerializedName("chat_is_channel")
    private Boolean chatIsChannel;

    /**
     * Optional. Pass True to request a forum supergroup, pass False to request a non-forum chat.
     * If not specified, no additional restrictions are applied
     */
    @SerializedName("chat_is_forum")
    @Nullable
    private Boolean chatIsForum;

    /**
     * Optional. Pass True to request a supergroup or a channel with a username, pass False to request a chat
     * without a username. If not specified, no additional restrictions are applied
     */
    @SerializedName("chat_has_username")
    @Nullable
    private Boolean chatHasUsername;

    /**
     * Optional. Pass True to request a chat owned by the user. Otherwise, no additional restrictions are applied
     */
    @SerializedName("chat_is_created")
    @Nullable
    private Boolean chatIsCreated;

    /**
     * Optional. A {@link ChatAdministratorRights} object listing the required administrator rights of the user
     * in the chat. If not specified, no additional restrictions are applied.
     */
    @SerializedName("user_administrator_rights")
    @Nullable
    private ChatAdministratorRights userAdministratorRights;

    /**
     * Optional. A {@link ChatAdministratorRights} object listing the required administrator rights of the bot in
     * the chat. If not specified, no additional restrictions are applied.
     */
    @SerializedName("bot_administrator_rights")
    @Nullable
    private ChatAdministratorRights botAdministratorRights;

    /**
     * Optional. Pass True to request a chat with the bot as a member. Otherwise,
     * no additional restrictions are applied.
     */
    @SerializedName("bot_is_member")
    @Nullable
    private Boolean botIsMember;
}