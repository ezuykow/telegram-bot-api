package kz.pandev.legrambotapi.models.types.common.bot.command.scope;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * Represents the scope of bot commands, covering all private chats.
 * @author ezuykow
 */
@EqualsAndHashCode(callSuper = true)
@ToString
public class BotCommandScopeAllPrivateChats extends BotCommandScope implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Scope type
     */
    private static final String SCOPE_TYPE = "all_private_chats";

    public BotCommandScopeAllPrivateChats() {
        this.type = SCOPE_TYPE;
    }
}