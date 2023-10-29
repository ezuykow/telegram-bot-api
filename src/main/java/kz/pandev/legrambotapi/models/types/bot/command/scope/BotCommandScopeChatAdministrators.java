package kz.pandev.legrambotapi.models.types.bot.command.scope;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * Represents the scope of bot commands, covering all administrators of a specific group or supergroup chat.
 * @author ezuykow
 */
@EqualsAndHashCode(callSuper = true)
@ToString
public class BotCommandScopeChatAdministrators extends BotCommandScope implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Scope type
     */
    private static final String SCOPE_TYPE = "chat_administrators";

    /**
     * Unique identifier for the target chat or username of the target supergroup (in the format @supergroupusername)
     */
    @SerializedName("chat_id")
    @SuppressWarnings("java:S1948") /*This field may be only Number or String type - it's both Serializable*/
    private Object chatIdOrUsername;

    public BotCommandScopeChatAdministrators(Object chatIdOrUsername) {
        this.type = SCOPE_TYPE;
        if (chatIdOrUsername instanceof Number || chatIdOrUsername instanceof String) {
            this.chatIdOrUsername = chatIdOrUsername;
        } else {
            throw new WrongParameterTypeException("Type of parameter \"chatIdOrUsername\" must be a " +
                    "Number (Long, Integer) or String");
        }
    }
}