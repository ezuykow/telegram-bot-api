package kz.pandev.legrambotapi.models.types.bot.command.scope;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * Represents the default scope of bot commands.
 * Default commands are used if no commands with a narrower scope are specified for the user.
 * @author ezuykow
 */
@EqualsAndHashCode(callSuper = true)
@ToString
public class BotCommandScopeDefault extends BotCommandScope implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Scope type
     */
    private static final String SCOPE_TYPE = "default";

    public BotCommandScopeDefault() {
        this.type = SCOPE_TYPE;
    }
}