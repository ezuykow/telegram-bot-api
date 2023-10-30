package kz.pandev.legrambotapi.models.types.common.bot.command.scope;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * Represents the scope of bot commands, covering all group and supergroup chats.
 * @author ezuykow
 */
@EqualsAndHashCode(callSuper = true)
@ToString
public class BotCommandScopeAllGroupChats extends BotCommandScope implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Scope type
     */
    private static final String SCOPE_TYPE = "all_group_chats";

    public BotCommandScopeAllGroupChats() {
        this.type = SCOPE_TYPE;
    }
}