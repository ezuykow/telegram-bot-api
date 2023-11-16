package kz.pandev.legrambotapi.models.requests.common.delete;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.types.common.bot.command.scope.BotCommandScope;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to delete the list of the bot's commands for the given scope and user language.
 * After deletion, higher level commands will be shown to affected users. Returns True on success.
 * @author ezuykow
 */
public class DeleteMyCommands extends Request<DeleteMyCommands, Response> {

    public DeleteMyCommands() {
        super(Response.class);
    }

    //region API

    /**
     * Set parameter scope
     * @param scope Scope of users for which the commands are relevant. Defaults to BotCommandScopeDefault.
     * @return this request
     */
    public DeleteMyCommands scope(@NotNull BotCommandScope scope) {
        return addParameter("scope", scope);
    }

    /**
     * Set parameter language_code
     * @param languageCode A two-letter ISO 639-1 language code. If empty, commands will be applied to all users
     *                    from the given scope, for whose language there are no dedicated commands
     * @return this request
     */
    public DeleteMyCommands languageCode(@NotNull String languageCode) {
        return addParameter("language_code", languageCode);
    }

    //endregion
}