package kz.pandev.legrambotapi.models.requests.common.get;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.common.get.GetMyCommandsResponse;
import kz.pandev.legrambotapi.models.types.common.bot.command.scope.BotCommandScope;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Use this method to get the current list of the bot's commands for the given scope and user language.
 * Returns an Array of BotCommand objects. If commands aren't set, an empty list is returned.
 * @author ezuykow
 */
@Getter
public class GetMyCommands extends Request<GetMyCommands, GetMyCommandsResponse> {

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

    public GetMyCommands() {
        super(GetMyCommandsResponse.class);
    }

    //region API

    /**
     * Set parameter {@link GetMyCommands#scope}
     * @param scope new parameter value
     * @return this request
     */
    public GetMyCommands scope(@NotNull BotCommandScope scope) {
        this.scope = scope;
        return addParameter("scope", scope);
    }

    /**
     * Set parameter {@link GetMyCommands#languageCode}
     * @param languageCode new parameter value
     * @return this request
     */
    public GetMyCommands languageCode(@NotNull String languageCode) {
        this.languageCode = languageCode;
        return addParameter("language_code", languageCode);
    }

    //endregion
}