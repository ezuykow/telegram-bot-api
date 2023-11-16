package kz.pandev.legrambotapi.models.requests.common.get;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.common.get.GetMyCommandsResponse;
import kz.pandev.legrambotapi.models.types.common.bot.command.scope.BotCommandScope;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to get the current list of the bot's commands for the given scope and user language.
 * Returns an Array of BotCommand objects. If commands aren't set, an empty list is returned.
 * @author ezuykow
 */
public class GetMyCommands extends Request<GetMyCommands, GetMyCommandsResponse> {

    public GetMyCommands() {
        super(GetMyCommandsResponse.class);
    }

    //region API

    /**
     * Set parameter scope
     * @param scope Scope of users for which the commands are relevant. Defaults to BotCommandScopeDefault.
     * @return this request
     */
    public GetMyCommands scope(@NotNull BotCommandScope scope) {
        return addParameter("scope", scope);
    }

    /**
     * Set parameter language_code
     * @param languageCode A two-letter ISO 639-1 language code. If empty, commands will be applied to all users
     *                    from the given scope, for whose language there are no dedicated commands
     * @return this request
     */
    public GetMyCommands languageCode(@NotNull String languageCode) {
        return addParameter("language_code", languageCode);
    }

    //endregion
}