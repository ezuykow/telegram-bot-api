package kz.pandev.legrambotapi.models.requests.common.delete;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.types.common.bot.command.scope.BotCommandScope;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Use this method to delete the list of the bot's commands for the given scope and user language.
 * After deletion, higher level commands will be shown to affected users. Returns True on success.
 * @author ezuykow
 */
@Getter
public class DeleteMyCommands extends Request<DeleteMyCommands, Response> {

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

    public DeleteMyCommands() {
        super(Response.class);
    }

    //region API

    /**
     * Set parameter {@link DeleteMyCommands#scope}
     * @param scope new parameter value
     * @return this request
     */
    public DeleteMyCommands scope(@NotNull BotCommandScope scope) {
        this.scope = scope;
        return addParameter("scope", scope);
    }

    /**
     * Set parameter {@link DeleteMyCommands#languageCode}
     * @param languageCode new parameter value
     * @return this request
     */
    public DeleteMyCommands languageCode(@NotNull String languageCode) {
        this.languageCode = languageCode;
        return addParameter("language_code", languageCode);
    }

    //endregion
}