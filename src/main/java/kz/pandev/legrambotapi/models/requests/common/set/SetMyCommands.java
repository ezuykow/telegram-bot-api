package kz.pandev.legrambotapi.models.requests.common.set;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.requests.common.AnswerCallbackQuery;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.types.common.bot.command.BotCommand;
import kz.pandev.legrambotapi.models.types.common.bot.command.scope.BotCommandScope;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

/**
 * Use this method to change the list of the bot's commands. See
 * <a href="https://core.telegram.org/bots/features#commands">this manual</a>
 * for more details about bot commands. Returns True on success.
 * @author ezuykow
 */
@Getter
public class SetMyCommands extends Request<SetMyCommands, Response> {

    /**
     * Optional. Scope of users for which the commands are relevant. Defaults to BotCommandScopeDefault.
     */
    @Nullable
    private BotCommandScope scope;
    /**
     * Optional. A two-letter ISO 639-1 language code. If empty, commands will be applied to all
     * users from the given scope, for whose language there are no dedicated commands
     */
    @Nullable
    private String languageCode;

    /**
     * @param commands array of {@link BotCommand}
     */
    public SetMyCommands(BotCommand... commands) {
        this(Arrays.asList(commands));
    }

    /**
     * @param commands {@link List} of {@link BotCommand}
     */
    public SetMyCommands(List<BotCommand> commands) {
        super(Response.class);
        addParameter("commands", commands);
    }

    //region API

    /**
     * Set parameter {@link SetMyCommands#scope}
     * @param scope new parameter value
     * @return this request
     */
    public SetMyCommands scope(@NotNull BotCommandScope scope) {
        this.scope = scope;
        return addParameter("scope", scope);
    }

    /**
     * Set parameter {@link SetMyCommands#languageCode}
     * @param languageCode new parameter value
     * @return this request
     */
    public SetMyCommands languageCode(@NotNull String languageCode) {
        this.languageCode = languageCode;
        return addParameter("language_code", languageCode);
    }

    //endregion
}