package kz.pandev.legrambotapi.models.types.bot.command.scope;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * Represents the scope of bot commands, covering all group and supergroup chat administrators.
 * @author ezuykow
 */
@EqualsAndHashCode(callSuper = true)
@ToString
public class BotCommandScopeAllChatAdministrators extends BotCommandScope implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Scope type
     */
    private static final String SCOPE_TYPE = "all_chat_administrators";

    public BotCommandScopeAllChatAdministrators() {
        this.type = SCOPE_TYPE;
    }
}