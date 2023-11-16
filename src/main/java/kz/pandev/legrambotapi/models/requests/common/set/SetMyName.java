package kz.pandev.legrambotapi.models.requests.common.set;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to change the bot's name. Returns True on success.
 * @author ezuykow
 */
public class SetMyName extends Request<SetMyName, Response> {

    public SetMyName() {
        super(Response.class);
    }

    //region API

    /**
     * Set parameter name
     * @param name New bot name; 0-64 characters. Pass an empty string to remove the dedicated name
     *            for the given language.
     * @return this request
     */
    public SetMyName name(@NotNull String name) {
        return addParameter("name", name);
    }

    /**
     * Set parameter language_code
     * @param languageCode A two-letter ISO 639-1 language code. If empty, commands will be applied to all users
     *                    from the given scope, for whose language there are no dedicated name
     * @return this request
     */
    public SetMyName languageCode(@NotNull String languageCode) {
        return addParameter("language_code", languageCode);
    }

    //endregion
}