package kz.pandev.legrambotapi.models.requests.common.set;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to change the bot's description, which is shown in the chat with the bot if the chat is empty.
 * Returns True on success.
 * @author ezuykow
 */
public class SetMyDescription extends Request<SetMyDescription, Response> {

    public SetMyDescription() {
        super(Response.class);
    }

    //region API

    /**
     * Set parameter description
     * @param description New bot description; 0-512 characters. Pass an empty string to remove the
     *                   dedicated description for the given language.
     * @return this request
     */
    public SetMyDescription description(@NotNull String description) {
        return addParameter("description", description);
    }

    /**
     * Set parameter language_code
     * @param languageCode A two-letter ISO 639-1 language code. If empty, commands will be applied to all users
     *                    from the given scope, for whose language there are no dedicated description
     * @return this request
     */
    public SetMyDescription languageCode(@NotNull String languageCode) {
        return addParameter("language_code", languageCode);
    }

    //endregion
}